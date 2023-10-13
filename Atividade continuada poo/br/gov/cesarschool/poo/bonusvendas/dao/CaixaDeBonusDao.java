package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;

class CaixaDeBonusDAO {
    private static final String BRANCO = "";
    private CadastroObjetos cadastro = new CadastroObjetos(CaixaDeBonus.class);

    public CaixaDeBonus buscar(int numero) {
        return (CaixaDeBonus) cadastro.buscar(BRANCO + numero);
    }

    public CaixaDeBonus[] buscarTodos() {
        Serializable[] arrayCaixas = cadastro.buscarTodos(CaixaDeBonus.class);
        CaixaDeBonus[] caixas = new CaixaDeBonus[arrayCaixas.length];
        for (int i = 0; i < arrayCaixas.length; i++) {
            caixas[i] = (CaixaDeBonus) arrayCaixas[i];
        }
        return caixas;
    }
    
    public boolean incluir(CaixaDeBonus caixa) {
        CaixaDeBonus caixaBusca = buscar(caixa.getNumero());
        if (caixaBusca != null) {
            return false;
        } else {
            cadastro.incluir(caixa, BRANCO + caixa.getNumero());
            return true;
        }
    }

    public boolean alterar(CaixaDeBonus caixa) {
        CaixaDeBonus caixaBusca = buscar(caixa.getNumero());
        if (caixaBusca == null) {
            return false;
        } else {
            cadastro.alterar(caixa, BRANCO + caixa.getNumero());
            return true;
        }
    }
    
    public boolean excluir(int numero) {
        CaixaDeBonus caixaBusca = buscar(numero);
        if (caixaBusca == null) {
            return false; 
        } else {
            cadastro.excluir(BRANCO + numero);
            return true; 
        }
    }
}