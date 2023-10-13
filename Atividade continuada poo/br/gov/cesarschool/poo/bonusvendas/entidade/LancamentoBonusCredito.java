package br.gov.cesarschool.poo.bonusvendas.entidade;

public class LancamentoBonusCredito extends LancamentoBonus {
    private TipoResgate tipoResgate;

    public LancamentoBonusCredito(long numeroCaixaBonus, double valor, TipoResgate tipoResgate) {
        super(numeroCaixaBonus, valor);
        this.tipoResgate = tipoResgate;
    }

    public TipoResgate getTipoResgate() {
        return tipoResgate;
    }
}