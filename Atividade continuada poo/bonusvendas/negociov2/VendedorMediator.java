package br.gov.cesarschool.poo.bonusvendas.negociov2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import br.gov.cesarschool.poo.bonusvendas.daov2.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ErroValidacao;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoValidacao;

public class VendedorMediator {
	private static VendedorMediator instancia;
	public static VendedorMediator getInstancia() {
		if (instancia == null) {
			instancia = new VendedorMediator();
		}
		return instancia;
	}
	private VendedorDAO repositorioVendedor;
	private AcumuloResgateMediator caixaDeBonusMediator;
	private VendedorMediator() {
		repositorioVendedor = new VendedorDAO();
		caixaDeBonusMediator = AcumuloResgateMediator.getInstancia();
	}

	public long incluir(Vendedor vendedor) throws ExcecaoObjetoJaExistente, ExcecaoValidacao, ExcecaoObjetoNaoExistente{
		validar(vendedor);
		repositorioVendedor.incluir(vendedor);
		return caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
	}

	public void alterar(Vendedor vendedor) throws ExcecaoObjetoNaoExistente, ExcecaoValidacao {
		validar(vendedor);
		repositorioVendedor.alterar(vendedor);
	}

	public Vendedor buscar(String cpf) throws ExcecaoObjetoNaoExistente {
        return repositorioVendedor.buscar(cpf);
    }

	private void validar(Vendedor vendedor) throws ExcecaoValidacao {
		ArrayList<ErroValidacao> erros = new ArrayList<>();
	
		if (StringUtil.ehNuloOuBranco(vendedor.getCpf())) {
			erros.add(new ErroValidacao(1, "CPF nao informado"));
		} else if (!ValidadorCPF.ehCpfValido(vendedor.getCpf())) {
			erros.add(new ErroValidacao(2, "CPF invalido"));
		}
	
		if (StringUtil.ehNuloOuBranco(vendedor.getNomeCompleto())) {
			erros.add(new ErroValidacao(3, "Nome completo nao informado"));
		}
	
		if (vendedor.getSexo() == null) {
			erros.add(new ErroValidacao(4, "Sexo nao informado"));
		}
	
		if (vendedor.getDataNascimento() == null) {
			erros.add(new ErroValidacao(5, "Data de nascimento nao informada"));
		} else if (dataNascimentoInvalida(vendedor.getDataNascimento())) {
			erros.add(new ErroValidacao(6, "Data de nascimento invalida"));
		}
	
		if (vendedor.getRenda() < 0) {
			erros.add(new ErroValidacao(7, "Renda menor que zero"));
		}
	
		if (vendedor.getEndereco() == null) {
			erros.add(new ErroValidacao(8, "Endereco nao informado"));
		} else {
			validarEndereco(vendedor.getEndereco(), erros);
		}
	
		if (!erros.isEmpty()) {
			throw new ExcecaoValidacao(erros);
		}
	}
	
	private void validarEndereco(Endereco endereco, ArrayList<ErroValidacao> erros) {
		if (StringUtil.ehNuloOuBranco(endereco.getLogradouro())) {
			erros.add(new ErroValidacao(9, "Logradouro nao informado"));
		} else if (endereco.getLogradouro().length() < 4) {
			erros.add(new ErroValidacao(10, "Logradouro tem menos de 04 caracteres"));
		}
	
		if (endereco.getNumero() < 0) {
			erros.add(new ErroValidacao(11, "Numero menor que zero"));
		}
	
		if (StringUtil.ehNuloOuBranco(endereco.getCidade())) {
			erros.add(new ErroValidacao(12, "Cidade nao informada"));
		}
	
		if (StringUtil.ehNuloOuBranco(endereco.getEstado())) {
			erros.add(new ErroValidacao(13, "Estado nao informado"));
		}
	
		if (StringUtil.ehNuloOuBranco(endereco.getPais())) {
			erros.add(new ErroValidacao(14, "Pais nao informado"));
		}
	}
	
	private boolean dataNascimentoInvalida(LocalDate dataNasc) {
		long yearsDifference = ChronoUnit.YEARS.between(dataNasc, LocalDate.now());
		return yearsDifference < 17;
	}
}