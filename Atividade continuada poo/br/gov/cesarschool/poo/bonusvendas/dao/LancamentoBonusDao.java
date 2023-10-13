package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;

public class LancamentoBonusDAO {
    private static final String BRANCO = "";
    private CadastroObjetos cadastro = new CadastroObjetos(LancamentoBonus.class);

    public LancamentoBonus buscar(String id) {
        return (LancamentoBonus) cadastro.buscar(id);
    }

    public LancamentoBonus[] buscarTodos() {
        Serializable[] arrayLancamentos = cadastro.buscarTodos(LancamentoBonus.class);
        LancamentoBonus[] lancamentos = new LancamentoBonus[arrayLancamentos.length];
        for (int i = 0; i < arrayLancamentos.length; i++) {
            lancamentos[i] = (LancamentoBonus) arrayLancamentos[i];
        }
        return lancamentos;
    }
    
    public boolean incluir(LancamentoBonus lancamento) {
        String id = lancamento.getNumeroCaixa() + lancamento.getDataHoraLancamento();
        LancamentoBonus lancamentoBusca = buscar(id);
        if (lancamentoBusca != null) {
            return false;
        } else {
            cadastro.incluir(lancamento, id);
            return true;
        }
    }

    public boolean alterar(LancamentoBonus lancamento) {
        String id = lancamento.getNumeroCaixa() + lancamento.getDataHoraLancamento();
        LancamentoBonus lancamentoBusca = buscar(id);
        if (lancamentoBusca == null) {
            return false;
        } else {
            cadastro.alterar(lancamento, id);
            return true;
        }
    }

    public boolean excluir(String id) {
        LancamentoBonus lancamentoBusca = buscar(id);
        if (lancamentoBusca == null) {
            return false; 
        } else {
            cadastro.excluir(id);
            return true; 
        }
    }
}