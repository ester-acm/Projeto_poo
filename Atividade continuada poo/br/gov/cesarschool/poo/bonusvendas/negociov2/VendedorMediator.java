package br.gov.cesarschool.poo.bonusvendas.negociov2;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import br.gov.cesarschool.poo.bonusvendas.daov2.VendedorDAO;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.StringUtil;
import br.gov.cesarschool.poo.bonusvendas.negocio.geral.ValidadorCPF;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ErroValidacao;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoValidacao;

package br.gov.cesarschool.poo.bonusvendas.negociov2;

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

	public long incluir(Vendedor vendedor) throws ExcecaoObjetoJaExistente, ExcecaoValidacao{
		validar(vendedor);
		repositorioVendedor.incluir(vendedor);
		return caixaDeBonusMediator.gerarCaixaDeBonus(vendedor);
	}
		return new ResultadoInclusaoVendedor(numeroCaixaBonus, msg);
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
			erros.add(new ErroValidacao("CPF nao informado", 1));
		} else if (!ValidadorCPF.ehCpfValido(vendedor.getCpf())) {
			erros.add(new ErroValidacao("CPF invalido", 2));
		}
	
		if (StringUtil.ehNuloOuBranco(vendedor.getNomeCompleto())) {
			erros.add(new ErroValidacao("Nome completo nao informado", 3));
		}
	
		if (vendedor.getSexo() == null) {
			erros.add(new ErroValidacao("Sexo nao informado", 4));
		}
	
		if (vendedor.getDataNascimento() == null) {
			erros.add(new ErroValidacao("Data de nascimento nao informada", 5));
		} else if (dataNascimentoInvalida(vendedor.getDataNascimento())) {
			erros.add(new ErroValidacao("Data de nascimento invalida", 6));
		}
	
		if (vendedor.getRenda() < 0) {
			erros.add(new ErroValidacao("Renda menor que zero", 7));
		}
	
		if (vendedor.getEndereco() == null) {
			erros.add(new ErroValidacao("Endereco nao informado", 8));
		} else {
			validarEndereco(vendedor.getEndereco(), erros);
		}
	
		if (!erros.isEmpty()) {
			throw new ExcecaoValidacao(erros);
		}
	}
	
	private void validarEndereco(Endereco endereco, ArrayList<ErroValidacao> erros) {
		if (StringUtil.ehNuloOuBranco(endereco.getLogradouro())) {
			erros.add(new ErroValidacao("Logradouro nao informado", 9));
		} else if (endereco.getLogradouro().length() < 4) {
			erros.add(new ErroValidacao("Logradouro tem menos de 04 caracteres", 10));
		}
	
		if (endereco.getNumero() < 0) {
			erros.add(new ErroValidacao("Numero menor que zero", 11));
		}
	
		if (StringUtil.ehNuloOuBranco(endereco.getCidade())) {
			erros.add(new ErroValidacao("Cidade nao informada", 12));
		}
	
		if (StringUtil.ehNuloOuBranco(endereco.getEstado())) {
			erros.add(new ErroValidacao("Estado nao informado", 13));
		}
	
		if (StringUtil.ehNuloOuBranco(endereco.getPais())) {
			erros.add(new ErroValidacao("Pais nao informado", 14));
		}
	}
	
	private boolean dataNascimentoInvalida(LocalDate dataNasc) {
		long yearsDifference = ChronoUnit.YEARS.between(dataNasc, LocalDate.now());
		return yearsDifference < 17;
	}
}