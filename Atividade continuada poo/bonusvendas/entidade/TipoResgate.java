package br.gov.cesarschool.poo.bonusvendas.entidade;

public enum TipoResgate {

    PRODUTO (1,"produto"),
    SERVICO (2,"servico"),
    CASH (3,"cash");

    private int codigo;
    private String descricao;
    private TipoResgate(int codigo, String descricao){
        this.descricao = descricao;
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }

}