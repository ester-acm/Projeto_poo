package br.gov.cesarschool.poo.bonusvendas.dao;

import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

public class VendedorDAO {
    private final DAOGenerico dao;

    public VendedorDAO() {
        this.dao = new DAOGenerico(Vendedor.class);
    }

    public boolean incluir(Vendedor vendedor) {
        Vendedor vendBusca = buscar(vendedor.getCpf());
        if (vendBusca != null) {
            return false;
        } else {
            dao.incluir(vendedor);
            return true;
        }
    }

    public boolean alterar(Vendedor vendedor) {
        Vendedor vendBusca = buscar(vendedor.getCpf());
        if (vendBusca == null) {
            return false;
        } else {
            dao.alterar(vendedor);
            return true;
        }
    }

    public Vendedor buscar(String cpf) {
        return (Vendedor) dao.buscar(cpf);
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