package br.gov.cesarschool.poo.bonusvendas.negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.gov.cesarschool.poo.bonusvendas.daov2.CaixaDeBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.daov2.LancamentoBonusDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoValidacao;


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

	public long gerarCaixaDeBonus(Vendedor vendedor) throws ExcecaoObjetoJaExistente {
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
        LancamentoBonusDebito lancamento = new LancamentoBonusDebito(numeroCaixaDeBonus, valor, LocalDateTime.now(), tipoResgate);
        repositorioLancamento.incluir(lancamento);
    } catch (ExcecaoObjetoJaExistente e) {
        throw new ExcecaoValidacao("Inconsistência no cadastro de lançamento");
    }

}