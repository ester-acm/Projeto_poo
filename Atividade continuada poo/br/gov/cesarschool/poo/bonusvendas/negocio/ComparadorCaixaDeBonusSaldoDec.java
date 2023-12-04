package br.gov.cesarschool.poo.bonusvendas.negocio;
import br.gov.cesarschool.poo.bonusvendas.util.Comparador;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;

public class ComparadorCaixaDeBonusSaldoDec implements Comparador{

	
	//saying there will only be one instance of this class.
	private static ComparadorCaixaDeBonusSaldoDec instancia = null;
	
	//declaring variables if there are any
	
	
	//Making a Singleton:
	//make a constructor for the public class ComparadorCaixaDeBonusSaldoDec
	//since calabria asked for a singleton, the singleton classes' constructor
	//has to be private

	private ComparadorCaixaDeBonusSaldoDec() {

	}
	
	//then, i need to make a static method that returns the same type object of the singleton class, 
	//the method can be written with LAZY INITIALIZATION
	//then, store the instance as a private static variable.
	
	public static synchronized ComparadorCaixaDeBonusSaldoDec getInstance()
    {
        if (instancia == null)
            instancia = new ComparadorCaixaDeBonusSaldoDec();
 
        return instancia;
    }
	
	
	
	//TO INSTANTIATE A normal class: we use java constructor
	//TO INSTANTIATE A SINGLETON: USE getInstance() METHOD!
	
	//implementing the abstract method contained in the "Comparador" Class
	public int comparar(Object o1, Object o2) {
		//Recebendo 2 objetos do tipo CaixaDeBonus
		CaixaDeBonus primeiraCaixa = (CaixaDeBonus) o1;
		CaixaDeBonus segundaCaixa = (CaixaDeBonus) o2;
	
		if (primeiraCaixa.getSaldo( ) > segundaCaixa.getSaldo( ) ) {
			return  -1;
		}else if(primeiraCaixa.getSaldo( ) == segundaCaixa.getSaldo( ) ) {
			return 0;
		}
		//else if(primeiraCaixa.getSaldo( ) < segundaCaixa.getSaldo( ) ) {
			return 1;
		
	  }
 }


//Deve ser um Singleton com método getInstance(). OK
//➔ Deve implementar a interface Comparador. OK
//➔ Deve implementar o método comparar considerando que serão recebidos dois
//objetos do tipo CaixaDeBonus, retornando a comparação dos saldos das caixas de
//bônus, ou seja, se um saldo (que é um double) é maior, menor ou igual a outro
//saldo. Como este comparador vai ser usado para ordenar caixas de bônus em ordem
//DECRESCENTE DE SALDO, A LÓGICA DE RETORNO DEVE SER INVERTIDA em relação à
//especificação do método comparar da interface Comparador.

