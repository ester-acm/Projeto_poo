package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;


public class VendedorDAO {
    private final DAOGenerico dao;

    public VendedorDAO() {
        this.dao = new DAOGenerico(Vendedor.class, "Vendedor");
    }

    public void incluir(Vendedor vend) throws ExcecaoObjetoJaExistente{
		dao.incluir(vend);	 
	}
	
	public void alterar(Vendedor vend) throws ExcecaoObjetoNaoExistente{
		dao.alterar(vend);	
	}
	
	public Vendedor buscar(String cpf) throws ExcecaoObjetoNaoExistente{
		return (Vendedor)dao.buscar(cpf);
	}

    public Vendedor[] buscarTodos() {
        Registro[] rets = dao.buscarTodos();
        Vendedor[] vendedores = new Vendedor[rets.length];
        for (int i = 0; i < rets.length; i++) {
            vendedores[i] = (Vendedor) rets[i];
        }
        return vendedores;
    }
}