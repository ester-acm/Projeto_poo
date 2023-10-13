package br.gov.cesarschool.poo.bonusvendas.entidade;

public class LancamentoBonusDebito extends LancamentoBonus {
    private TipoResgate tipoResgate;
    public LancamentoBonusDebito(long numeroCaixaBonus, double valor, TipoResgate tipoResgate) {
        super(numeroCaixaBonus, valor);
        this.tipoResgate=tipoResgate;

    }
}
