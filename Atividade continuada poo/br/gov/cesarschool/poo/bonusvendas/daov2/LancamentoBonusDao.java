package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.LancamentoBonus;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;


public class LancamentoBonusDAO {
    private final DAOGenerico dao;

    public LancamentoBonusDAO() {
        this.dao = new DAOGenerico(LancamentoBonus.class, "Lancamento");
    }

    public void incluir(LancamentoBonus lancamento) throws ExcecaoObjetoJaExistente{
		dao.incluir(lancamento); 
	}
	
	public void alterar(LancamentoBonus lancamento) throws ExcecaoObjetoNaoExistente{
		dao.alterar(lancamento);	
	}
	
	public LancamentoBonus buscar(String codigo) throws ExcecaoObjetoNaoExistente {
		return (LancamentoBonus)dao.buscar(codigo);
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