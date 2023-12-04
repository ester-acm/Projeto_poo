package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.gov.cesarschool.poo.bonusvendas.daov2.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.daov2.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.daov2.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoValidacao;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorCaixaDeBonusSaldoDec;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorLancamentoBonusDHDec;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorVendedorNome;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorVendedorRenda;
import br.gov.cesarschool.poo.bonusvendas.util.Ordenadora;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class AcumuloResgateMediator {
	private static final String CAIXA_DE_BONUS_INEXISTENTE = "Caixa de bonus inexistente";
	private static final String VALOR_MENOR_OU_IGUAL_A_ZERO = "Valor menor ou igual a zero";
	private static AcumuloResgateMediator instancia;
	public static AcumuloResgateMediator getInstancia() {
		if (instancia == null) {
			instancia = new AcumuloResgateMediator();
		}
		return instancia;
	}
	private CaixaDeBonusDAO repositorioCaixaDeBonus;
	private LancamentoBonusDAO repositorioLancamento;
	private AcumuloResgateMediator() {
		repositorioCaixaDeBonus = new CaixaDeBonusDAO();
		repositorioLancamento = new LancamentoBonusDAO();
	}

	public long gerarCaixaDeBonus(Vendedor vendedor) throws ExcecaoObjetoJaExistente, ExcecaoObjetoNaoExistente {
		LocalDate dataAtual = LocalDate.now();
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		long numero = Long.parseLong(vendedor.getCpf().substring(0, 9) + dataAtual.format(customFormatter));
		CaixaDeBonus caixa = new CaixaDeBonus(numero);
	
		try {
			repositorioCaixaDeBonus.incluir(caixa);
			return numero;
		} catch (ExcecaoObjetoJaExistente e) { /*Não está no doc mas só sei fazer com cactch */
			throw new ExcecaoObjetoJaExistente("Falha ao gerar a Caixa de bonus: " + e.getMessage());
		}
	}

	public void acumularBonus(long numeroCaixaDeBonus, double valor) throws ExcecaoObjetoNaoExistente, ExcecaoValidacao {
		if (valor <= 0) {
			throw new ExcecaoValidacao(VALOR_MENOR_OU_IGUAL_A_ZERO);
		}
	
		CaixaDeBonus caixa = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
	
		if (caixa == null) {
			throw new ExcecaoObjetoNaoExistente("Caixa de bônus inexistente");
		}
	
		caixa.creditar(valor);
		repositorioCaixaDeBonus.alterar(caixa);
	
		try {
			repositorioLancamento.incluir(new LancamentoBonusCredito(numeroCaixaDeBonus, valor, LocalDateTime.now()));
		} catch (ExcecaoObjetoJaExistente e) {
			throw new ExcecaoValidacao("Inconsistência no cadastro de lançamento");
		}
	}
	
	public void resgatar(long numeroCaixaDeBonus, double valor, TipoResgate tipoResgate) throws ExcecaoObjetoNaoExistente, ExcecaoObjetoJaExistente, ExcecaoValidacao {
		if (valor <= 0) {
			throw new ExcecaoValidacao(VALOR_MENOR_OU_IGUAL_A_ZERO);
		}
	
		CaixaDeBonus caixa = repositorioCaixaDeBonus.buscar(numeroCaixaDeBonus);
	
		if (caixa == null) {
			throw new ExcecaoObjetoNaoExistente("Caixa de bônus inexistente");
		}
	
		if (caixa.getSaldo() < valor) {
			throw new ExcecaoObjetoJaExistente("Saldo insuficiente");
		}
	
		caixa.debitar(valor);
		repositorioCaixaDeBonus.alterar(caixa);
	
		try {
			repositorioLancamento.incluir(new LancamentoBonusDebito(numeroCaixaDeBonus, valor, LocalDateTime.now(), tipoResgate));
		} catch (ExcecaoObjetoJaExistente e) {
			throw new ExcecaoValidacao("Inconsistência no cadastro de lançamento");
		}
	}
	
	public CaixaDeBonus[] listaCaixaDeBonusPorSaldoMaior(double saldoInicial) {
		CaixaDeBonus[] caixas = repositorioCaixaDeBonus.buscarTodos();
		
		CaixaDeBonus[] selecaoCaixas = Arrays.stream(caixas)
                .filter(caixa -> caixa.getSaldo() >= saldoInicial)
                .toArray(CaixaDeBonus[]::new);
		
		Ordenadora.ordenar(selecaoCaixas, ComparadorCaixaDeBonusSaldoDec.getInstance());
		
		return selecaoCaixas;
	}
	
	public LancamentoBonus[] listaLancamentosPorFaixaData(LocalDate d1, LocalDate d2) {
        LancamentoBonus[] lancamentos = repositorioLancamento.buscarTodos();

        List<LancamentoBonus> selecaoLancamentos = new ArrayList<>();

        for (LancamentoBonus lancamento : lancamentos) {
            LocalDate dataHoraLancamento = lancamento.getDataHoraLancamento().toLocalDate();
            if (!dataHoraLancamento.isBefore(d1) && !dataHoraLancamento.isAfter(d2)) {
                selecaoLancamentos.add(lancamento);
            }
        }

        Collections.sort(selecaoLancamentos, ComparadorLancamentoBonusDHDec.getInstance());

        return selecaoLancamentos.toArray(new LancamentoBonus[0]);
    }
	
	
}


/**
 * Um novo método público :
CaixaDeBonus[] listaCaixaDeBonusPorSaldoMaior(double saldoInicial)
o O método deve chamar o buscar todos do DAO de caixas de bônus, e o
retorno deste método deve ser filtrado para popular um novo array, que
deve conter somente as caixas de bônus cujos saldos forem maiores ou
iguais ao parâmetro “saldoInicial”. Este novo array deve ser ordenado por
saldo em ordem decrescente e retornado. A ordenação deve ser feita
usando-se as classes Ordenadora e ComparadorCaixaDeBonusSaldoDec.
 * 
 * 
 * 
 * 
 * Um novo método público:
// O tipo LocalDate dos parâmetros é do pacote JAVA java.time.
LancamentoBonus[] listaLancamentosPorFaixaData(LocalDate d1, LocalDate d2)
o O método deve chamar o buscar todos do DAO de lançamentos, e o retorno
deste método deve ser filtrado para popular um novo array, que deve conter
somente os lançamentos cujas datas (parte do atributo
dataHoraLancamento) forem maiores ou iguais ao parâmetro “d1” e
menores ou iguais ao parâmetro “d2” Este novo array deve estar ordenado
por data hora lançamento em ordem decrescente para ser retornado. A
ordenação deve ser feita usando-se as classes Collections (do pacote
java.util do JAVA) e ComparadorLancamentoBonusDHDec.
 * 
 */