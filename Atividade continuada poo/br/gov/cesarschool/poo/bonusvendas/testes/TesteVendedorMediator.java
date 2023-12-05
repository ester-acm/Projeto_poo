package br.gov.cesarschool.poo.bonusvendas.testes;
<<<<<<< HEAD

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
=======
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
>>>>>>> 5d91b3eba25847baf4969fbf7bef4521ae2421e1

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
<<<<<<< HEAD
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import br.gov.cesarschool.poo.bonusvendas.negocio.ResultadoInclusaoVendedor;
import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;
import x.y.z.w.k.Glosb;

public class TesteVendedorMediator extends TesteGeral {
	
	private static final String NUMERO_MENOR_QUE_ZERO = "Numero menor que zero";
	private static final String LOGRADOURO_TEM_MENOS_DE_04_CARACTERES = "Logradouro tem menos de 04 caracteres";
	private static final String ENDERECO_NAO_INFORMADO = "Endereco nao informado";
	private static final String RENDA_MENOR_QUE_ZERO = "Renda menor que zero";
	private static final String DATA_DE_NASCIMENTO_INVALIDA = "Data de nascimento invalida";
	private static final String DATA_DE_NASCIMENTO_NAO_INFORMADA = "Data de nascimento nao informada";
	private static final String SEXO_NAO_INFORMADO = "Sexo nao informado";
	private static final String CPF_INVALIDO = "CPF invalido";	
	private static final String SUF_NEW = "_NEW";
	private static final int NUMERO_CAIXA_BONUS_NAO_GERADA = 0;
	private static final String PAIS_NAO_INFORMADO = "Pais nao informado";
	private static final String ESTADO_NAO_INFORMADO = "Estado nao informado";
	private static final String CIDADE_NAO_INFORMADA = "Cidade nao informada";
	private static final String NOME_COMPLETO_NAO_INFORMADO = "Nome completo nao informado";
	private static final String LOGRADOURO_NAO_INFORMADO = "Logradouro nao informado";
	private static final String CPF_NAO_INFORMADO = "CPF nao informado";
	private static final LocalDate OUTRA_DATA_NASC_VALIDA = LocalDate.parse("2003-05-12");	
	
	private static final Vendedor[] VENDS_INVALIDOS = {
			new Vendedor(null, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor("  ", NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor("12345678901", NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, null, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, "   ", 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					null, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, null, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, LocalDate.parse("2022-01-01"), RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, -3000.11,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0, null),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(null, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(BRANCO, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco("ABC", NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, -1, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		null, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(BRANCO, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, null, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, BRANCO, PAIS_VALIDO + SUF_NEW)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, null)),
			new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
					Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 2000.0,
			        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO, COMPL_VALIDO + SUF_NEW, CEP_VALIDO, 
			        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, "   "))
	};
	private static final String[] MSGS_VENDS_INVALIDOS = {
			CPF_NAO_INFORMADO,
			CPF_NAO_INFORMADO,
			CPF_INVALIDO,
			NOME_COMPLETO_NAO_INFORMADO,
			NOME_COMPLETO_NAO_INFORMADO,
			SEXO_NAO_INFORMADO,
			DATA_DE_NASCIMENTO_NAO_INFORMADA,
			DATA_DE_NASCIMENTO_INVALIDA,
			RENDA_MENOR_QUE_ZERO,
			ENDERECO_NAO_INFORMADO,
			LOGRADOURO_NAO_INFORMADO,
			LOGRADOURO_NAO_INFORMADO,
			LOGRADOURO_TEM_MENOS_DE_04_CARACTERES,
			NUMERO_MENOR_QUE_ZERO,
			CIDADE_NAO_INFORMADA,
			CIDADE_NAO_INFORMADA,
			ESTADO_NAO_INFORMADO,
			ESTADO_NAO_INFORMADO,
			PAIS_NAO_INFORMADO,
			PAIS_NAO_INFORMADO			
	};
	
	private VendedorMediator mediator = VendedorMediator.getInstancia();
	
	@Test
	public void testCpfNaoPreenchido() {
		Vendedor vend = new Vendedor(null, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, CPF_NAO_INFORMADO);		
		vend = new Vendedor("  ", NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));	
		assertInclusaoNaoRealizada(vend, CPF_NAO_INFORMADO);
	}	
	@Test
	public void testCpfInvalido() {
		Vendedor vend = new Vendedor("12345678901", NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, CPF_INVALIDO);
	}
	@Test
	public void testNomeCompletoNaoInformado() {
		Vendedor vend = new Vendedor(CPF_VALIDO, null, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, NOME_COMPLETO_NAO_INFORMADO);
		vend = new Vendedor(CPF_VALIDO, "   ", 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, NOME_COMPLETO_NAO_INFORMADO);
	}
	@Test
	public void testSexoNaoInformado() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				null, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, SEXO_NAO_INFORMADO);
	}
	@Test
	public void testDataNascimentoNaoInformada() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, null, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, DATA_DE_NASCIMENTO_NAO_INFORMADA);
	}
	@Test
	public void testDataNascimentoInvalida() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, LocalDate.parse("2022-01-01"), RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, DATA_DE_NASCIMENTO_INVALIDA);
	}
	@Test
	public void testRendaInvalida() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, -3000.11,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, RENDA_MENOR_QUE_ZERO);
	}
	@Test
	public void testEnderecoNaoInformado() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA, null);
		assertInclusaoNaoRealizada(vend, ENDERECO_NAO_INFORMADO);
	}
	@Test
	public void testLogradouroNaoInformado() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(null, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, LOGRADOURO_NAO_INFORMADO);
		vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(BRANCO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, LOGRADOURO_NAO_INFORMADO);
	}
	@Test
	public void testLogradouroInvalido() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco("ABC", NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, LOGRADOURO_TEM_MENOS_DE_04_CARACTERES);
	}
	@Test
	public void testNumeroInvalido() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, -1, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, NUMERO_MENOR_QUE_ZERO);
	}
	@Test
	public void testCidadeNaoInformada() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		null, ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, CIDADE_NAO_INFORMADA);
		vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		" ", ESTADO_VALIDO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, CIDADE_NAO_INFORMADA);
	}
	@Test
	public void testEstadoNaoInformado() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, null, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, ESTADO_NAO_INFORMADO);
		vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, BRANCO, PAIS_VALIDO));
		assertInclusaoNaoRealizada(vend, ESTADO_NAO_INFORMADO);
	}
	@Test
	public void testPaisNaoInformado() {
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, null));
		assertInclusaoNaoRealizada(vend, PAIS_NAO_INFORMADO);
		vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, "   "));
		assertInclusaoNaoRealizada(vend, PAIS_NAO_INFORMADO);
	}
	@Test
	public void testIncluirChaveDuplicada() {		
		excluirVendedoresCaixasBonusLancamentos();
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		long numero = Glosb.gluarfsh(vend.getCpf());
		CaixaDeBonus caixaBonusOri = new CaixaDeBonus(numero);
		cadastroVend.incluir(vend, CPF_VALIDO);
		cadastroCaixaBonus.incluir(caixaBonusOri, numero + BRANCO);
		Vendedor vend1 = new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
				Sexo.FEMININO, DATA_NASC_VALIDA, RENDA_VALIDA + 100.0,
		        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO + 100, COMPL_VALIDO + SUF_NEW, CEP_VALIDO + SUF_NEW, 
		        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW));				
		ResultadoInclusaoVendedor res = mediator.incluir(vend1);
		Assertions.assertNotNull(res);
		Assertions.assertEquals("Vendedor ja existente", res.getMensagemErroValidacao());
		Assertions.assertEquals(NUMERO_CAIXA_BONUS_NAO_GERADA, res.getNumeroCaixaDeBonus());
		int qtdArqsVendedor = obterQtdArquivosDir(DIR_VENDEDOR);
		int qtdArqsCaixaDeBonus = obterQtdArquivosDir(DIR_CAIXA_DE_BONUS);
		Assertions.assertEquals(1, qtdArqsVendedor);
		Assertions.assertEquals(1, qtdArqsCaixaDeBonus);
		Vendedor vendGravado = (Vendedor)cadastroVend.buscar(CPF_VALIDO);		
		Assertions.assertNotNull(vendGravado);
		Assertions.assertTrue(ComparadoraObjetosSerial.compareObjectsSerial(vend, vendGravado));		
		CaixaDeBonus caixaBonusGravada = (CaixaDeBonus)cadastroCaixaBonus.buscar(numero + BRANCO);
		Assertions.assertNotNull(caixaBonusGravada);
		Assertions.assertEquals(caixaBonusGravada.getNumero(), caixaBonusOri.getNumero());
		Assertions.assertEquals(caixaBonusGravada.getSaldo(), caixaBonusOri.getSaldo());
	}
	@Test
	public void testIncluirSucesso() {		
		excluirVendedoresCaixasBonusLancamentos();
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));		
		long numero = Glosb.gluarfsh(vend.getCpf());
		CaixaDeBonus caixaBonusOri = new CaixaDeBonus(numero);
		ResultadoInclusaoVendedor res = mediator.incluir(vend);
		Assertions.assertNotNull(res);
		Assertions.assertNull(res.getMensagemErroValidacao());
		Assertions.assertEquals(numero, res.getNumeroCaixaDeBonus());
		int qtdArqsVendedor = obterQtdArquivosDir(DIR_VENDEDOR);
		int qtdArqsCaixaDeBonus = obterQtdArquivosDir(DIR_CAIXA_DE_BONUS);
		Assertions.assertEquals(1, qtdArqsVendedor);
		Assertions.assertEquals(1, qtdArqsCaixaDeBonus);
		Vendedor vendInc = (Vendedor)cadastroVend.buscar(CPF_VALIDO);
		Assertions.assertNotNull(vendInc);
		Assertions.assertTrue(ComparadoraObjetosSerial.compareObjectsSerial(vend, vendInc));
		CaixaDeBonus caixaBonusGravada = (CaixaDeBonus)cadastroCaixaBonus.buscar(numero + BRANCO);
		Assertions.assertNotNull(caixaBonusGravada);
		Assertions.assertEquals(caixaBonusGravada.getNumero(), caixaBonusOri.getNumero());
		Assertions.assertEquals(caixaBonusGravada.getSaldo(), caixaBonusOri.getSaldo());		
	}
	@Test
	public void testAlterarChaveNaoExistente() {		
		excluirVendedoresCaixasBonusLancamentos();
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		long numero = Glosb.gluarfsh(vend.getCpf());
		CaixaDeBonus caixaBonusOri = new CaixaDeBonus(numero);
		cadastroVend.incluir(vend, CPF_VALIDO);
		cadastroCaixaBonus.incluir(caixaBonusOri, numero + BRANCO);
		Vendedor vend1 = new Vendedor(OUTRO_CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
				Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 100.0,
		        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO + 100, COMPL_VALIDO + SUF_NEW, CEP_VALIDO + SUF_NEW, 
		        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW));				
		String msg = mediator.alterar(vend1);
		Assertions.assertEquals("Vendedor inexistente", msg);		
		int qtdArqsVendedor = obterQtdArquivosDir(DIR_VENDEDOR);
		int qtdArqsCaixaDeBonus = obterQtdArquivosDir(DIR_CAIXA_DE_BONUS);
		Assertions.assertEquals(1, qtdArqsVendedor);
		Assertions.assertEquals(1, qtdArqsCaixaDeBonus);
		Vendedor vendGravado = (Vendedor)cadastroVend.buscar(CPF_VALIDO);		
		Assertions.assertNotNull(vendGravado);
		Assertions.assertTrue(ComparadoraObjetosSerial.compareObjectsSerial(vend, vendGravado));		
		CaixaDeBonus caixaBonusGravada = (CaixaDeBonus)cadastroCaixaBonus.buscar(numero + BRANCO);
		Assertions.assertNotNull(caixaBonusGravada);
		Assertions.assertEquals(caixaBonusGravada.getNumero(), caixaBonusOri.getNumero());
		Assertions.assertEquals(caixaBonusGravada.getSaldo(), caixaBonusOri.getSaldo());
	}
	@Test
	public void testAlterarDadosInvalidos() {
		Vendedor vendOri = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		for (int i=0; i< VENDS_INVALIDOS.length; i++) {
			assertAlteracaoNaoRealizada(vendOri, VENDS_INVALIDOS[i], MSGS_VENDS_INVALIDOS[i]);
		}
	}
	@Test
	public void testAlterarSucesso() {		
		excluirVendedoresCaixasBonusLancamentos();
		Vendedor vend = new Vendedor(CPF_VALIDO, NOME_VALIDO, 
				Sexo.MASCULINO, DATA_NASC_VALIDA, RENDA_VALIDA,
		        new Endereco(LOGR_VALIDO, NUMERO_VALIDO, COMPL_VALIDO, CEP_VALIDO, 
		        		CIDADE_VALIDA, ESTADO_VALIDO, PAIS_VALIDO));
		long numero = Glosb.gluarfsh(vend.getCpf());
		CaixaDeBonus caixaBonusOri = new CaixaDeBonus(numero);
		cadastroVend.incluir(vend, CPF_VALIDO);
		cadastroCaixaBonus.incluir(caixaBonusOri, numero + BRANCO);
		Vendedor vend1 = new Vendedor(CPF_VALIDO, NOME_VALIDO + SUF_NEW, 
				Sexo.FEMININO, OUTRA_DATA_NASC_VALIDA, RENDA_VALIDA + 100.0,
		        new Endereco(LOGR_VALIDO + SUF_NEW, NUMERO_VALIDO + 100, COMPL_VALIDO + SUF_NEW, CEP_VALIDO + SUF_NEW, 
		        		CIDADE_VALIDA + SUF_NEW, ESTADO_VALIDO + SUF_NEW, PAIS_VALIDO + SUF_NEW));				
		String msg = mediator.alterar(vend1);
		Assertions.assertNull(msg);		
		int qtdArqsVendedor = obterQtdArquivosDir(DIR_VENDEDOR);
		int qtdArqsCaixaDeBonus = obterQtdArquivosDir(DIR_CAIXA_DE_BONUS);
		Assertions.assertEquals(1, qtdArqsVendedor);
		Assertions.assertEquals(1, qtdArqsCaixaDeBonus);
		Vendedor vendAlterado = (Vendedor)cadastroVend.buscar(CPF_VALIDO);		
		Assertions.assertNotNull(vendAlterado);
		Assertions.assertTrue(ComparadoraObjetosSerial.compareObjectsSerial(vend1, vendAlterado));		
		CaixaDeBonus caixaBonusGravada = (CaixaDeBonus)cadastroCaixaBonus.buscar(numero + BRANCO);
		Assertions.assertNotNull(caixaBonusGravada);
		Assertions.assertEquals(caixaBonusGravada.getNumero(), caixaBonusOri.getNumero());
		Assertions.assertEquals(caixaBonusGravada.getSaldo(), caixaBonusOri.getSaldo());
	}
	
	private boolean diretorioVazio(String caminhoDir) {
		File[] files = (new File(caminhoDir)).listFiles();
		return files == null || files.length == 0;  
	}

//	private String callValidar(Vendedor vend) {
//		try {
//			Class<?> clazz = mediator.getClass();
//			Method privateMethod = clazz.getDeclaredMethod("validar", Vendedor.class);
//			privateMethod.setAccessible(true);
//			return (String)privateMethod.invoke(mediator, vend);
//		} catch (Exception e) {
//			e.printStackTrace();	
//			throw new RuntimeException(e);
//		}		
//	}
	private void assertInclusaoNaoRealizada(Vendedor vend, String msgErro) {
		excluirVendedoresCaixasBonusLancamentos();
		ResultadoInclusaoVendedor res = mediator.incluir(vend);
		Assertions.assertNotNull(res);
		Assertions.assertNotNull(res.getMensagemErroValidacao());
		Assertions.assertEquals(NUMERO_CAIXA_BONUS_NAO_GERADA, res.getNumeroCaixaDeBonus());
		Assertions.assertEquals(msgErro, res.getMensagemErroValidacao());
		Assertions.assertTrue(diretorioVazio(DIR_VENDEDOR));
		Assertions.assertTrue(diretorioVazio(DIR_CAIXA_DE_BONUS));					
	}
	private void assertAlteracaoNaoRealizada(Vendedor vendOri, Vendedor vend, String msgErro) {
		excluirVendedoresCaixasBonusLancamentos();
		cadastroVend.incluir(vendOri, vendOri.getCpf());
		long numero = Glosb.gluarfsh(vendOri.getCpf());
		CaixaDeBonus caixaBonusOri = new CaixaDeBonus(numero);
		cadastroCaixaBonus.incluir(caixaBonusOri, numero + BRANCO);
		String msg = mediator.alterar(vend);
		Assertions.assertNotNull(msg);
		Assertions.assertNotNull(msgErro, msg);
		int qtdArqsVendedor = obterQtdArquivosDir(DIR_VENDEDOR);
		int qtdArqsCaixaDeBonus = obterQtdArquivosDir(DIR_CAIXA_DE_BONUS);
		Assertions.assertEquals(1, qtdArqsVendedor);
		Assertions.assertEquals(1, qtdArqsCaixaDeBonus);
		Vendedor vendGravado = (Vendedor)cadastroVend.buscar(vendOri.getCpf());		
		Assertions.assertNotNull(vendGravado);
		Assertions.assertTrue(ComparadoraObjetosSerial.compareObjectsSerial(vendOri, vendGravado));		
		CaixaDeBonus caixaBonusGravada = (CaixaDeBonus)cadastroCaixaBonus.buscar(numero + BRANCO);
		Assertions.assertNotNull(caixaBonusGravada);
		Assertions.assertEquals(caixaBonusGravada.getNumero(), caixaBonusOri.getNumero());
		Assertions.assertEquals(caixaBonusGravada.getSaldo(), caixaBonusOri.getSaldo());		
	}
}
=======
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusCredito;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonusDebito;
import br.gov.cesarschool.poo.bonusvendas.entidade.TipoResgate;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;
import br.gov.cesarschool.poo.bonusvendas.negocio.AcumuloResgateMediator;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorCaixaDeBonusSaldoDec;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorLancamentoBonusDHDec;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorVendedorRenda;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorVendedorNome;
import br.gov.cesarschool.poo.bonusvendas.negocio.ComparadorVendedorRenda;
import br.gov.cesarschool.poo.bonusvendas.negocio.VendedorMediator;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;
import br.gov.cesarschool.poo.bonusvendas.util.Ordenadora;
public class TesteRelatorios extends TesteGeral {
	private static final String ACUMULO_RESGATE_MEDIATOR_JAVA = "AcumuloResgateMediator.java";
	private static final double VALOR_MIL = 1000.0;
	private static final String VEND_MEDIATOR_JAVA = "VendedorMediator.java";
	private static final String STR_ORDENADORA = "Ordenadora.ordenar";
	private static final String DIR_MEDIATORS = IND_CUR_DIR + FILE_SEP + "src" + 
			FILE_SEP + "br" + FILE_SEP + "gov" + FILE_SEP + "cesarschool" + 
			FILE_SEP + "poo" + FILE_SEP + "bonusvendas" + FILE_SEP + "negocio" + FILE_SEP;
	private static final Vendedor[] VENDS = new Vendedor[] {
		new Vendedor("1", "EDUARDO", Sexo.MASCULINO, null, 2000.0, null),
		new Vendedor("2", "CARLA", Sexo.FEMININO, null, 3000.0, null),
		new Vendedor("3", "ZORO", Sexo.MASCULINO, null, 1500.0, null),
		new Vendedor("4", "BABI", Sexo.FEMININO, null, 8000.0, null)};
	
	@Test
	public void testComparadoresImplementors() {
		Assertions.assertTrue(ComparadorVendedorNome.getInstance() 
				instanceof Comparador);
		Assertions.assertTrue(ComparadorVendedorRenda.getInstance() 
				instanceof Comparador); 
		Assertions.assertTrue(ComparadorCaixaDeBonusSaldoDec.getInstance() 
				instanceof Comparador); 
		Assertions.assertTrue(ComparadorLancamentoBonusDHDec.getInstance() 
				instanceof Comparator); 
	}
	@Test
	public void testSingletonConstrutorPrivado() {		
		testSingletonConstrutorAux(ComparadorLancamentoBonusDHDec.class); 
		testSingletonConstrutorAux(ComparadorVendedorNome.class);
		testSingletonConstrutorAux(ComparadorVendedorRenda.class); 
		testSingletonConstrutorAux(ComparadorCaixaDeBonusSaldoDec.class); 
	}
	@Test
	public void testOrdenacaoGeral() {
		EntTesteOrdenacao[] lista = new EntTesteOrdenacao[4];
		lista[0] = new EntTesteOrdenacao(2, "BRUNO");
		lista[1] = new EntTesteOrdenacao(1, "AMERICO");
		lista[2] = new EntTesteOrdenacao(4, "ZORO");
		lista[3] = new EntTesteOrdenacao(3, "SERGEI");
		Comparador comp = new Comparador() {			
			@Override
			public int comparar(Object o1, Object o2) {
				return ((EntTesteOrdenacao)o1).at2.compareTo(
						((EntTesteOrdenacao)o2).at2);
			}
		};
		Ordenadora.ordenar(lista, comp);
		Assertions.assertEquals("AMERICO", lista[0].at2);
		Assertions.assertEquals("BRUNO", lista[1].at2);
		Assertions.assertEquals("SERGEI", lista[2].at2);
		Assertions.assertEquals("ZORO", lista[3].at2);		
	}
	@Test
	public void testOrdenacaoVendedor() {		
		Vendedor[] vends = new Vendedor[VENDS.length];
		System.arraycopy(VENDS, 0, vends, 0, VENDS.length);
		Ordenadora.ordenar(vends, ComparadorVendedorNome.getInstance());
		assertVendedorNome(vends);
		vends = new Vendedor[VENDS.length];
		System.arraycopy(VENDS, 0, vends, 0, VENDS.length);		
		Ordenadora.ordenar(vends, ComparadorVendedorRenda.getInstance());
		assertVendedorRenda(vends);		
	}
	@Test
	public void testOrdenacaoCaixaDeBonus() {
		CaixaDeBonus[] caixas = new CaixaDeBonus[4];
		caixas[0] = new CaixaDeBonus(1);
		caixas[1] = new CaixaDeBonus(2);
		caixas[2] = new CaixaDeBonus(3);
		caixas[3] = new CaixaDeBonus(4);
		caixas[0].creditar(10000.0);
		caixas[1].creditar(1000.0);
		caixas[2].creditar(3000.0);
		caixas[3].creditar(2000.0);
		Ordenadora.ordenar(caixas, ComparadorCaixaDeBonusSaldoDec.getInstance());
		Assertions.assertEquals(1, caixas[0].getNumero());
		Assertions.assertEquals(3, caixas[1].getNumero());
		Assertions.assertEquals(4, caixas[2].getNumero());
		Assertions.assertEquals(2, caixas[3].getNumero());
	}	
	@Test
	public void testOrdenacaoLancamentoBonus() {
		List lancs = new ArrayList();
		LocalDateTime dh1 = LocalDateTime.parse("2001-01-01T00:00:00");
		LocalDateTime dh2 = LocalDateTime.parse("2001-01-01T00:02:01");
		LocalDateTime dh3 = LocalDateTime.parse("2012-10-11T22:33:11");
		LocalDateTime dh4 = LocalDateTime.parse("2023-06-03T00:00:01");
		lancs.add(new LancamentoBonusCredito(1, VALOR_MIL, dh4));
		lancs.add(new LancamentoBonusDebito(2, VALOR_MIL, dh1, TipoResgate.CASH));
		lancs.add(new LancamentoBonusCredito(3, VALOR_MIL, dh3));
		lancs.add(new LancamentoBonusDebito(4, VALOR_MIL, dh2, TipoResgate.PRODUTO));
		Collections.sort(lancs, ComparadorLancamentoBonusDHDec.getInstance());
		Assertions.assertEquals(1, ((LancamentoBonus)lancs.get(0)).getNumeroCaixaDeBonus());
		Assertions.assertEquals(3, ((LancamentoBonus)lancs.get(1)).getNumeroCaixaDeBonus());
		Assertions.assertEquals(4, ((LancamentoBonus)lancs.get(2)).getNumeroCaixaDeBonus());
		Assertions.assertEquals(2, ((LancamentoBonus)lancs.get(3)).getNumeroCaixaDeBonus());
	}
	@Test
	public void testRelatoriosVendedorNome() {
		excluirVendedoresCaixasBonusLancamentos();
		for (Vendedor vendedor : VENDS) {
			cadastroVend.incluir(vendedor, vendedor.getIdUnico());
		}		
		Vendedor[] vendsOrdNome = VendedorMediator.getInstancia().gerarListagemClienteOrdenadaPorNome();
		Assertions.assertNotNull(vendsOrdNome);
		Assertions.assertEquals(4, vendsOrdNome.length);				
		assertVendedorNome(vendsOrdNome);
		testUsoComparadoresAux(VEND_MEDIATOR_JAVA, "ComparadorVendedorNome.getInstance()", STR_ORDENADORA);
	}
	@Test
	public void testRelatoriosVendedorRenda() {
		excluirVendedoresCaixasBonusLancamentos();
		for (Vendedor vendedor : VENDS) {
			cadastroVend.incluir(vendedor, vendedor.getIdUnico());
		}		
		Vendedor[] vendsOrdRenda = VendedorMediator.getInstancia().gerarListagemClienteOrdenadaPorRenda();
		Assertions.assertNotNull(vendsOrdRenda);
		Assertions.assertEquals(4, vendsOrdRenda.length);						
		assertVendedorRenda(vendsOrdRenda);		
		testUsoComparadoresAux(VEND_MEDIATOR_JAVA, "ComparadorVendedorRenda.getInstance()", STR_ORDENADORA);
	}
	
	@Test
	public void testRelatorioCaixaDeBonus() {
		excluirVendedoresCaixasBonusLancamentos(); 
		CaixaDeBonus[] caixas = new CaixaDeBonus[6];
		caixas[0] = new CaixaDeBonus(1);
		caixas[1] = new CaixaDeBonus(2);
		caixas[2] = new CaixaDeBonus(3);
		caixas[3] = new CaixaDeBonus(4);
		caixas[4] = new CaixaDeBonus(5);
		caixas[5] = new CaixaDeBonus(6);
		caixas[0].creditar(8000.0);
		caixas[1].creditar(2000.0);
		caixas[2].creditar(3000.0);
		caixas[3].creditar(10000.0);
		caixas[4].creditar(1000.0);				
		caixas[5].creditar(4000.0);
		for (CaixaDeBonus caixaDeBonus : caixas) {
			cadastroCaixaBonus.incluir(caixaDeBonus, caixaDeBonus.getIdUnico());
		}	
		CaixaDeBonus[] caixasRet = AcumuloResgateMediator.getInstancia().listaCaixaDeBonusPorSaldoMaior(3000.0);
		Assertions.assertNotNull(caixasRet);
		Assertions.assertEquals(4, caixasRet.length);		
		Assertions.assertEquals(4, caixasRet[0].getNumero());
		Assertions.assertEquals(1, caixasRet[1].getNumero());
		Assertions.assertEquals(6, caixasRet[2].getNumero());
		Assertions.assertEquals(3, caixasRet[3].getNumero());
		testUsoComparadoresAux(ACUMULO_RESGATE_MEDIATOR_JAVA, "ComparadorCaixaDeBonusSaldoDec.getInstance()", STR_ORDENADORA);
	}
	@Test
	public void testRelatorioLancamento() {
		excluirVendedoresCaixasBonusLancamentos(); 
		List lancs = new ArrayList();
		LocalDateTime dh1 = LocalDateTime.parse("2001-01-01T23:59:59");
		LocalDateTime dh2 = LocalDateTime.parse("2020-12-01T11:02:01");
		LocalDateTime dh3 = LocalDateTime.parse("2020-12-02T22:33:11");
		LocalDateTime dh4 = LocalDateTime.parse("2021-02-04T08:21:44");
		LocalDateTime dh5 = LocalDateTime.parse("2022-06-07T19:10:58");
		LocalDateTime dh6 = LocalDateTime.parse("2023-06-03T06:34:01");
		LocalDate d1 = LocalDate.parse("2020-12-01");
		LocalDate d2 = LocalDate.parse("2022-06-07");
		lancs.add(new LancamentoBonusDebito(5, VALOR_MIL, dh5, TipoResgate.SERVICO));
		lancs.add(new LancamentoBonusCredito(4, VALOR_MIL, dh4));
		lancs.add(new LancamentoBonusDebito(1, VALOR_MIL, dh1, TipoResgate.CASH));
		lancs.add(new LancamentoBonusCredito(3, VALOR_MIL, dh3));
		lancs.add(new LancamentoBonusCredito(6, VALOR_MIL, dh6));
		lancs.add(new LancamentoBonusDebito(2, VALOR_MIL, dh2, TipoResgate.PRODUTO));		
		for (Object object : lancs) {			
			LancamentoBonus lanc = (LancamentoBonus)object;
			cadastroLanc.incluir(lanc, lanc.getIdUnico());
		}
		LancamentoBonus[] lancsRet = AcumuloResgateMediator.getInstancia().listaLancamentosPorFaixaData(d1, d2);
		Assertions.assertNotNull(lancsRet);
		Assertions.assertEquals(4, lancsRet.length);
		Assertions.assertEquals(5, lancsRet[0].getNumeroCaixaDeBonus());				
		Assertions.assertEquals(4, lancsRet[1].getNumeroCaixaDeBonus());
		Assertions.assertEquals(3, lancsRet[2].getNumeroCaixaDeBonus());
		Assertions.assertEquals(2, lancsRet[3].getNumeroCaixaDeBonus());
		testUsoComparadoresAux(ACUMULO_RESGATE_MEDIATOR_JAVA, "ComparadorLancamentoBonusDHDec.getInstance()", "Collections.sort");
	}
	private void testSingletonConstrutorAux(Class clazz) {		
		Constructor[] consts = clazz.getDeclaredConstructors();
		Assertions.assertEquals(1, consts.length);
		Assertions.assertEquals(2, consts[0].getModifiers());
	}	
	private void testUsoComparadoresAux(String nomeArqJava, String nomeComparador, String nomeMetodoOrdenador) {				
		File arqDao = new File(DIR_MEDIATORS + nomeArqJava); 
		Assertions.assertTrue(arqDao.exists());
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(arqDao, "r");
			byte[] contByte = new byte[(int)raf.length()];
			raf.read(contByte);
			String conteudo = new String(contByte);
			Assertions.assertTrue(conteudo.indexOf(nomeComparador) >= 0);
			Assertions.assertTrue(conteudo.indexOf(nomeMetodoOrdenador) >= 0);
		} catch (Exception e) {
			Assertions.fail(e);
		} finally {
			try {
				raf.close();
			} catch (Exception e) {}
		}
	}
	private void assertVendedorRenda(Vendedor[] vends) {
		Assertions.assertEquals("3", vends[0].getCpf());
		Assertions.assertEquals("1", vends[1].getCpf());
		Assertions.assertEquals("2", vends[2].getCpf());
		Assertions.assertEquals("4", vends[3].getCpf());
	}
	private void assertVendedorNome(Vendedor[] vends) {
		Assertions.assertEquals("4", vends[0].getCpf());
		Assertions.assertEquals("2", vends[1].getCpf());
		Assertions.assertEquals("1", vends[2].getCpf());
		Assertions.assertEquals("3", vends[3].getCpf());
	}
	private static class EntTesteOrdenacao {
		int at1;
		String at2;
		public EntTesteOrdenacao(int at1, String at2) {
			this.at1 = at1;
			this.at2 = at2;
		}
	}
}
>>>>>>> 5d91b3eba25847baf4969fbf7bef4521ae2421e1
