package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import java.time.LocalDateTime;
import java.util.Comparator;


public class ComparadorLancamentoBonusDHDec implements Comparator{

	
	//saying there will only be one instance of this class.
	private static ComparadorLancamentoBonusDHDec instancia = null;
	
	//declaring variables if there are any
	
	
	//Making a Singleton:
	//make a constructor for the public class ComparadorCaixaDeBonusSaldoDec
	//since calabria asked for a singleton, the singleton classes' constructor
	//has to be private

	private ComparadorLancamentoBonusDHDec() {

	}
	
	//then, i need to make a static method that returns the same type object of the singleton class, 
	//the method can be written with LAZY INITIALIZATION
	//then, store the instance as a private static variable.
	
	public static synchronized ComparadorLancamentoBonusDHDec getInstance()
    {
        if (instancia == null)
            instancia = new ComparadorLancamentoBonusDHDec();
 
        return instancia;
    }

	//TO INSTANTIATE A normal class: we use java constructor
	//TO INSTANTIATE A SINGLETON: USE getInstance() METHOD!
	
	//implementing the abstract method contained in the "Comparador" Class
	public int compare(Object o1, Object o2) {
		//Recebendo 2 objetos do tipo lLancamentoBonus
		LancamentoBonus primeiroLancamento = (LancamentoBonus) o1;
		LancamentoBonus segundoLancamento = (LancamentoBonus) o2;
		
		LocalDateTime dateTime1 = primeiroLancamento.getDataHoraLancamento();
		LocalDateTime dateTime2 = segundoLancamento.getDataHoraLancamento();
		
	
		int resultado = (dateTime1.compareTo(dateTime2));
		if (resultado > 0 ) {
			return  -1;
		}else if(resultado == 0) {
			return 0;
		}
		//else if(primeiraCaixa.getSaldo( ) < segundaCaixa.getSaldo( ) ) {
			return 1;
		
	  }
 }


//Deve ser um Singleton com método getInstance(). OK
//➔ Deve implementar a interface java.util.Comparator do JAVA. Não usar o recurso de
//tipo parametrizado (o <> sugerido pelas IDEs). OK
//➔ Deve implementar o método compare considerando que serão recebidos dois
//objetos do tipo LancamentoBonus OK, retornando a comparação das
//dataHoraLancamento dos lançamentos, ou seja, se uma dataHoraLancamento (que é
//do tipo LocalDateTime) é maior, menor ou igual a outra dataHoraLancamento. Como
//este comparador vai ser usado para ordenar lançamentos em ordem DECRESCENTE
//DE DATA HORA LANÇAMENTO, a lógica de retorno deve ser invertida em relação à
//especificação do método compare da interface java.util.Comparator. OK
// COMPARETO which is defined to return one of -1, 0, or 
//1 according to whether the value of expression is negative, zero or positive.