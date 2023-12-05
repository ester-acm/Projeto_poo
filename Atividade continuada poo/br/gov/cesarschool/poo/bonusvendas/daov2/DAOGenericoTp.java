package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;

public class DAOGenericoTp<T extends Registro> {
    private CadastroObjetos cadastro;
    private Class<T> tipo;
    private String nomeEntidade;

    public DAOGenericoTp(Class<T> tipo, String nomeEntidade) {
        this.cadastro = new CadastroObjetos(tipo);
        this.setTipo(tipo);
        this.nomeEntidade = nomeEntidade;
    }

    public void incluir(T reg) throws ExcecaoObjetoNaoExistente, ExcecaoObjetoJaExistente {
        cadastro.incluir(reg, reg.getIdUnico());
    }

    public void alterar(T reg) throws ExcecaoObjetoNaoExistente {
        cadastro.alterar(reg, reg.getIdUnico());
    }

    public T buscar(String id) throws ExcecaoObjetoNaoExistente {
        T busca = (T) cadastro.buscar(id);
        if (busca == null) {
            throw new ExcecaoObjetoNaoExistente(nomeEntidade + " não existente");
        }
        return busca;
    }

    public T[] buscarTodos() {
        Serializable[] rets = cadastro.buscarTodos(tipo);
        T[] registros = (T[]) java.lang.reflect.Array.newInstance(tipo, rets.length);
        for (int i = 0; i < rets.length; i++) {
            registros[i] = (T) rets[i];
        }
        return registros;
    }

    public Class<T> getTipo() {
        return tipo;
    }

    public void setTipo(Class<T> tipo) {
    	this.tipo = tipo;
    }
}