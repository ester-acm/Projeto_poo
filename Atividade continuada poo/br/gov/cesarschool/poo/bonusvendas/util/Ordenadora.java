package br.gov.cesarschool.poo.bonusvendas.util;

public class Ordenadora {

}
//*Esta classe não necessita ser instanciada para ser usada, portanto, o seu construtor
//deve ser sem parâmetros e privado.

// Deve ter um método público estático void ordenar(Object[] lista, Comparador
//comp): Este método deve ordenar a lista “lista” recebida como parâmetro, decidindo
//quando trocar objetos de lugar a partir do resultado do método comparar, invocado
//do comparador, que recebe os dois objetos a serem comparados. O algoritmo de
//ordenação segue abaixo.

//Algoritmo de ordenacao
ordenar(Object[] lista){
for(i=0 ate (lista.tamanho-1)){
for(k=(i+1) ate (lista.tamanho-1)){
if lista[i] > lista[k] {
	trocar lista[i] e lista[k] de posição;
}
}
}
}