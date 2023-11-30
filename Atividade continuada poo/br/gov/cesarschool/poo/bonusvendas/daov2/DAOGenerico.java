package br.gov.cesarschool.poo.bonusvendas.daov2;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoJaExistente;
import br.gov.cesarschool.poo.bonusvendas.excecoes.ExcecaoObjetoNaoExistente;

public class DAOGenerico {
   private CadastroObjetos cadastro;
   private Class<?> tipo;
   private String nomeEntidade; 

   public DAOGenerico(Class<?> tipo, String nomeEntidade) {
       this.cadastro = new CadastroObjetos(tipo);
       this.setTipo(tipo);
       this.nomeEntidade = nomeEntidade;
   }

   public void incluir(Registro reg) throws ExcecaoObjetoNaoExistente, ExcecaoObjetoJaExistente {
    cadastro.incluir(reg, reg.getIdUnico());
}

public void alterar(Registro reg) throws ExcecaoObjetoNaoExistente {
    cadastro.alterar(reg, reg.getIdUnico());
}

public Registro buscar(String id) throws ExcecaoObjetoNaoExistente {
	Registro busca = (Registro)cadastro.buscar(id);
	if (busca == null) {
		throw new ExcecaoObjetoNaoExistente(nomeEntidade + " nao existente");
	}
	return busca;
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