package br.gov.cesarschool.poo.bonusvendas.entidade.geral;
import java.util.Scanner;

public class Endereco {
	private int numero;
	private String logradouro;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	
	public Endereco(int numero, String logradouro, String complemento, String cep, String cidade, String estado, String pais) {
		//construtor deve inicializar todos os atributos da classe OK
		super();
		this.numero = numero;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}
	//sets e gets publicos para todos os atributos
	//como sets servem só para atribuir um valor, eles não precisam retornar nada ao usuário
	// podem ser do tipo void e devem receber como parâmetro o elemento que vao utilizar
	
	//sets:
	
	
	public void setNumero(int numero){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o número de sua residência: ");
        numero = scanner.nextInt();
        scanner.close();
    }
	
	public void setLogradouro(String logradouro){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Insira seu Logradouro: ");
        logradouro = scanner.toString();
        scanner.close();
    }
	
	public void setComplemento(String complemento){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o complemento: ");
        complemento = scanner.toString();
        scanner.close();
    }
	
	public void setCep(String cep){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Insira seu cep: ");
        cep = scanner.toString();
        scanner.close();
    }
	
	public void setCidade(String cidade){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Insira sua cidade? ");
        cidade = scanner.toString();
        scanner.close();
    }
	
	public void setEstado(String estado){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Insira seu estado: ");
        estado = scanner.toString();
        scanner.close();
    }
	
	public void setPais(String pais){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Insira seu país: ");
        pais = scanner.toString();
        scanner.close();
    }
	
	//gets
	
	public int getNumero(){
        return numero;
    }
	
		public String getLogradouro(){
        return logradouro;
    }
	
		public String getComplemento(){
	        return complemento;
	    }
		
		public String getCep(){
	        return cep;
	    }
		
		public String getCidade(){
	        return cidade;
	    }
		
		public String getEstado(){
	        return estado;
	    }
		
		public String getPais(){
	        return pais;
	    }
}
