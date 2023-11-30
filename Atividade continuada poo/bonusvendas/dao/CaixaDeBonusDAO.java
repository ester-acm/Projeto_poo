package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

public class CaixaDeBonusDAO {
    private final DAOGenerico dao;

    public CaixaDeBonusDAO() {
        this.dao = new DAOGenerico(CaixaDeBonus.class);
    }

    public void incluir(CaixaDeBonus caixaBonus) {
        dao.incluir(caixaBonus);
    }

    public void alterar(CaixaDeBonus caixaBonus) {
        dao.alterar(caixaBonus);
    }

    public CaixaDeBonus buscar(long numero) {
        return (CaixaDeBonus) dao.buscar(String.valueOf(numero));
    }

    public CaixaDeBonus[] buscarTodos() {
        Registro[] registros = dao.buscarTodos();
        CaixaDeBonus[] caixaBonus = new CaixaDeBonus[registros.length];
        for (int i = 0; i < registros.length; i++) {
            caixaBonus[i] = (CaixaDeBonus) registros[i];
        }
        return caixaBonus;
    }
}