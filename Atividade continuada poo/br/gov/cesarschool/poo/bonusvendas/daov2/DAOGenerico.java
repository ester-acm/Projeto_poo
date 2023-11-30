package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;

public class DAOGenerico {
   private CadastroObjetos cadastro;
   private Class<?> tipo;
   private String nomeEntidade; 

   public DAOGenerico(Class<?> tipo, String nomeEntidade; ) {
       this.cadastro = new CadastroObjetos(tipo);
       this.setTipo(tipo);
       this.nomeEntidade = nomeEntidade;
   }

   public void incluir(Registro reg) throws ExcecaoObjetoNaoExistente {
    try {
        cadastro.incluir(reg, reg.getIdUnico());
    } catch (ExcecaoObjetoJaExistente e) {
        throw new ExcecaoObjetoJaExistente(nomeEntidade + " já existente");
    }
}

public void alterar(Registro reg) throws ExcecaoObjetoNaoExistente {
    try {
        cadastro.alterar(reg, reg.getIdUnico());
    } catch (ExcecaoObjetoNaoExistente e) {
        throw new ExcecaoObjetoNaoExistente(nomeEntidade + " não existe");
    }
}

public Registro buscar(String id) throws ExcecaoObjetoNaoExistente {
    Registro registro = (Registro) cadastro.buscar(id);
    if (registro == null) {
        throw new ExcecaoObjetoNaoExistente(nomeEntidade + " não existe");
    }
    return registro;
}

   public Registro[] buscarTodos() {
       Serializable[] rets = cadastro.buscarTodos(Registro.class);
       Registro[] registros = new Registro[rets.length];
       for (int i = 0; i < rets.length; i++) {
           registros[i] = (Registro) rets[i];
       }
       return registros;
   }

	public Class<?> getTipo() {
		return tipo;
	}

	public void setTipo(Class<?> tipo) {
		this.tipo = tipo;
	}
} 