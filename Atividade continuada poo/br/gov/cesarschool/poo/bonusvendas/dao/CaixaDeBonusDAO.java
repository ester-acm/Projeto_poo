package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.CaixaDeBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

public class CaixaDeBonusDAO {
    private final DAOGenerico dao;

    public CaixaDeBonusDAO() {
        this.dao = new DAOGenerico(CaixaDeBonus.class);
    }

    public boolean incluir(CaixaDeBonus caixaBonus) {
		return dao.incluir(caixaBonus); 
	}
	public boolean alterar(CaixaDeBonus caixaBonus) {
		return dao.alterar(caixaBonus);	
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