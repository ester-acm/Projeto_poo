package br.gov.cesarschool.poo.bonusvendas.util;

public class Ordenadora {
	
	private Ordenadora(){
		
	}
	
	public static void ordenar(Object[] lista, Comparador comp) {

		 int tamanho =  lista.length;
		 
			for(int i=0; i <= (tamanho -1); i++){
				for(int k=(i+1);k <= (tamanho -1); k++) {
					//referenciando o metodo comparar presente na classe Comparador
					if(comp.comparar(lista[i], lista[k]) > 0) {
						Object temp = lista[i];
						lista[i] = lista[k];
						lista[k] = temp;
	                 }
                 }
		    }
     }
}

//Algoritmo de ordenacao


//*Esta classe não necessita ser instanciada para ser usada, portanto, o seu construtor
//deve ser sem parâmetros e privado. OK

//Deve ter um método público estático void ordenar(Object[] lista, Comparador
//comp): Este método deve ordenar a lista “lista” recebida como parâmetro, decidindo
//quando trocar objetos de lugar a partir do resultado do método comparar, invocado
//do comparador, que recebe os dois objetos a serem comparados. O algoritmo de
//ordenação segue abaixo.OK
