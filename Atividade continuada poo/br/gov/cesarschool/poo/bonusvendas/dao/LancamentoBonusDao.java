package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

public class LancamentoBonusDAO {
    private final DAOGenerico dao;

    public LancamentoBonusDAO() {
        this.dao = new DAOGenerico(LancamentoBonus.class);
    }

    public boolean incluir(LancamentoBonus lancamento) {
        String idUnico = lancamento.getIdUnico();
        LancamentoBonus lancamentoBusca = buscar(idUnico);
        if (lancamentoBusca != null) {
            return false;
        } else {
            dao.incluir(lancamento);
            return true;
        }
    }

    public boolean alterar(LancamentoBonus lancamento) {
        String idUnico = lancamento.getIdUnico();
        LancamentoBonus lancamentoBusca = buscar(idUnico);
        if (lancamentoBusca == null) {
            return false;
        } else {
            dao.alterar(lancamento);
            return true;
        }
    }

    public LancamentoBonus buscar(String codigo) {
        return (LancamentoBonus) dao.buscar(codigo);
    }

    public LancamentoBonus[] buscarTodos() {
        Registro[] rets = dao.buscarTodos();
        LancamentoBonus[] lancamentos = new LancamentoBonus[rets.length];
        for (int i = 0; i < rets.length; i++) {
            lancamentos[i] = (LancamentoBonus) rets[i];
        }
        return lancamentos;
    }
}