package br.gov.cesarschool.poo.bonusvendas.negocio;

import br.gov.cesarschool.poo.bonusvendas.util.Comparador;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class ComparadorVendedorNome implements Comparador{

	
	//saying there will only be one instance of this class.
	private static ComparadorVendedorNome instancia = null;
	
	//declaring variables if there are any
	
	
	//Making a Singleton:
	//make a constructor for the public class ComparadorCaixaDeBonusSaldoDec
	//since calabria asked for a singleton, the singleton classes' constructor
	//has to be private

	private ComparadorVendedorNome() {

	}
	
	//then, i need to make a static method that returns the same type object of the singleton class, 
	//the method can be written with LAZY INITIALIZATION
	//then, store the instance as a private static variable.
	
	public static synchronized ComparadorVendedorNome getInstance()
    {
        if (instancia == null)
            instancia = new ComparadorVendedorNome();
 
        return instancia;
    }

	//TO INSTANTIATE A normal class: we use java constructor
	//TO INSTANTIATE A SINGLETON: USE getInstance() METHOD!
	
	//implementing the abstract method contained in the "Comparador" Class
	public int comparar(Object o1, Object o2) {
		//Recebendo 2 objetos do tipo Vendedor
		Vendedor primeiroVendedor = (Vendedor) o1;
		Vendedor segundoVendedor = (Vendedor) o2;
		
		String nome1 = primeiroVendedor.getNomeCompleto();
		String nome2 = primeiroVendedor.getNomeCompleto();
	
		int resultadoNome = (nome1.compareTo(nome2));
		
		if (resultadoNome > 0) {
			return 1 ;
		}else if(resultadoNome == 0) {
			return 0;
		}
		//else if(primeiraCaixa.getSaldo( ) < segundaCaixa.getSaldo( ) ) {
			return -1;
		
	  }
 }



//Deve ser um Singleton com método getInstance(). OK
//➔ Deve implementar a interface Comparador. OK
//➔ Deve implementar o método comparar considerando que serão recebidos dois
//objetos do tipo Vendedor, retornando a comparação dos nomes dos vendedores, ou
//seja, se um nome completo (que é uma string) é lexicamente maior, menor ou igual
//a outro nome completo, nos termos da especificação do método comparar da
//interface Comparador. OK