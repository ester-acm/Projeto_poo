package br.gov.cesarschool.poo.bonusvendas.entidade;
import java.time.LocalDateTime;
import java.util.Scanner;


public class CaixaDeBonus {
	
	private long valor;     
	private static double saldo;
	private java.time.LocalDateTime dataHoraAtualizacao;

	public CaixaDeBonus() {
		//construtor deve inicializar somente o numero OK
		super();
		this.valor = valor;

	}

		//gets publicos para todos os atributos
		public long getValor(){
			return valor;
		}
		
		public double getSaldo() {
			return saldo;
		}
		
		public java.time.LocalDateTime getDataHoraAtualizacao() {
			return dataHoraAtualizacao;
		}
		
		
		public static void setSaldo() {
			Scanner scanner = new Scanner(System.in);
	        System.out.println("Insira o valor de seu saldo atual: ");
	        saldo = scanner.nextInt();
	        scanner.close();
		}   
	      
		//deve adicionar ao saldo atual o valor em questão
		//deve atualizar o dataHoraAtualizacao
		public static void creditar(long valor,java.time.LocalDateTime dataHoraAtualizacao ) {
			Scanner scanner = new Scanner(System.in);
	        System.out.println("Insira o valor que deseja creditar: ");
	        valor = scanner.nextInt();
	        scanner.close();
	        
	        //atualizando o saldo após o valor creditado
	        saldo = saldo + valor;
	        
	        //atualizando a data e hora atual
	        dataHoraAtualizacao = LocalDateTime.now();
			
		}
		
		//deve subtrair do saldo atual o valor em questão
		//deve atualizar o dataHoraAtualizacao
		public static void debitar(double valor, java.time.LocalDateTime dataHoraAtualizacao) {
			Scanner scanner = new Scanner(System.in);
	        System.out.println("Insira o valor que deseja debitar: ");
	        valor = scanner.nextInt();
	        scanner.close();
	        
	        //atualizando o saldo após o valor creditado
	        saldo = saldo - valor;
	        
	        //atualizando a data e hora atual
	        dataHoraAtualizacao = LocalDateTime.now();
			
			
			
		}
}
