package br.gov.cesarschool.poo.bonusvendas.entidade;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Scanner;

public class Vendedor {

	private String cpf;
	private String nomeCompleto;
	private br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo sexo;
	private java.time.LocalDate dataNascimento;
	private double renda;
	private br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco endereco;
	
	public Vendedor() {
		super();
		this.cpf = cpf;
		this.nomeCompleto = nomeCompleto;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.renda = renda;
		this.endereco = endereco;
		
		//this usado pra referenciar atributos proprios de uma classe e inicializalos dentro de seu respectivo construtor
		//no caso de eu querer inicializar no construtor dessa classe, atributos herdados, preciso colocá-los como parametro do super, que é o elemento
		//que faz menção ao super construtor, ou seja, o construtor da classe "maior"!
	}

	//Sets publicos para todos os atributos, menos o CPF
	
	public void setNomeCompleto(String nomeCompleto){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Insira o seu nome completo: ");
        nomeCompleto = scanner.toString();
        scanner.close();
    }
	
	//uso o this pra dizer que o sexo daqui deve ser inicializado/set com os mesmos valores da classe Sexo
	public void setSexo(br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo sexo){
		this.sexo = sexo;
    }
	
	public void setRenda(double renda){
		Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o valor correspondente a sua renda atual: ");
        renda = scanner.nextInt();
        scanner.close();
    }
	
	//uso o this pra dizer que o endereço daqui deve ser inicializado/set com os mesmos valores da classe Endereco
	public void setEndereco(br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco endereco){
		this.endereco = endereco;
    }
	
	//como devo fazer para pegar um input do usuário e colocar na formatação correta do tipo local date do java:
	
	public LocalDate setDataNascimento(String dataNascimento){
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Insira sua data de nascimento");
				dataNascimento = scanner.toString();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        return LocalDate.parse(dataNascimento, formatter);
			}
    }
	
	//gets para todos os atributos
	
	public String getCpf(){
        return cpf;
    }
	
	public String getNomeCompleto(){
        return nomeCompleto;
    }
	
	public br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo getsexo(){
        return sexo;
    }
	
	public java.time.LocalDate getDataNascimento(){
        return dataNascimento;
    }
	
	public double getRenda(){
        return renda;
    }
	
	public br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco getEndereco(){
        return endereco;
    }
	
	//deve, a partir da data atual(obter do java) e da data de nascimento
	//calcular a idade do vendedor(que é atributo de vendedor)
	public int calcularIdade(LocalDate dataNascimento) {
		
		int idade = 0;
		
		//instanciando a classe localDate do java para usar o metodo now
		//atribuindo o valor da data atual a variavel dataAtual
		LocalDate dataAtual = LocalDate.now();
		
		//usando a biblioteca java.time.period para comparar a data de nascimento com a  atual
		
		if((dataNascimento != null) && (dataAtual != null)) {
			idade = Period.between(dataNascimento, dataAtual).getYears();
		}
		else {
			idade = 0;
		}
	
		return idade;
	}
		

}
