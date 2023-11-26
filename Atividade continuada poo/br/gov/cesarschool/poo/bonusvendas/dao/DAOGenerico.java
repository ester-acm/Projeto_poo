package br.gov.cesarschool.poo.bonusvendas.dao;

import java.io.Serializable;

import br.edu.cesarschool.next.oo.persistenciaobjetos.CadastroObjetos;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Registro;

public class DAOGenerico {
   private CadastroObjetos cadastro;
   private Class<?> tipo;

   public DAOGenerico(Class<?> tipo) {
       this.cadastro = new CadastroObjetos(tipo);
       this.setTipo(tipo);
   }

   public void incluir(Registro reg) {
       cadastro.incluir(reg, reg.getIdUnico());
   }

   public void alterar(Registro reg) {
       cadastro.alterar(reg, reg.getIdUnico());
   }

   public Registro buscar(String id) {
       return (Registro) cadastro.buscar(id);
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