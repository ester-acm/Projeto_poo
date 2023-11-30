package br.gov.cesarschool.poo.bonusvendas.entidade.geral;

public enum Sexo {
	
	FEMININO (1, "F"),
	MASCULINO(2,"M");		
	//add restrição de domínio aos possíveis valores de sexo, f ou m
	
	private int codigo;
	private String descricao;
	
	
	private Sexo(int codigo, String descricao) {
		this.descricao = descricao;
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
