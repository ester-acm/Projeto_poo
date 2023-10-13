package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;
import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;

public class VendedorDAO {
    private static final String BRANCO = "";
    private CadastroObjetos cadastro = new CadastroObjetos(Vendedor.class);

    public Vendedor buscar(String cpf) {
        return (Vendedor) cadastro.buscar(BRANCO + cpf);
    }

    public Vendedor[] buscarTodos() {
        Serializable[] arrayVendedores = cadastro.buscarTodos(Vendedor.class);
        Vendedor[] vendedores = new Vendedor[arrayVendedores.length];
        for (int i = 0; i < arrayVendedores.length; i++) {
            vendedores[i] = (Vendedor) arrayVendedores[i];
        }
        return vendedores;
    }
    
    public boolean incluir(Vendedor vendedor) {
        Vendedor vendedorBusca = buscar(vendedor.getCpf());
        if (vendedorBusca != null) {
            return false;
        } else {
            cadastro.incluir(vendedor, BRANCO + vendedor.getCpf());
            return true;
        }
    }

    public boolean alterar(Vendedor vendedor) {
        Vendedor vendedorBusca = buscar(vendedor.getCpf());
        if (vendedorBusca == null) {
            return false;
        } else {
            cadastro.alterar(vendedor, BRANCO + vendedor.getCpf());
            return true;
        }
    }
    
    public boolean excluir(String cpf) {
        Vendedor vendedorBusca = buscar(cpf);
        if (vendedorBusca == null) {
            return false; 
        } else {
            cadastro.excluir(BRANCO + cpf);
            return true;
        }
    }
}
