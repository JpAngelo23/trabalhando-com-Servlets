package br.com.fiap.fintech.model;

public class CCorrente extends Conta {

    private int cdConta;
    private double txJuros;
    private double txIof;
    private double txIr;

    public CCorrente() {
    }

    public CCorrente(int cdConta, double txJuros, double txIof, double txIr) {
        this.cdConta = cdConta;
        this.txJuros = txJuros;
        this.txIof = txIof;
        this.txIr = txIr;
    }

    // Métodos Getters and Setters (removendo os herdados de Conta)


    public double getTxJuros() {
        return txJuros;
    }

    public void setTxJuros(double txJuros) {
        this.txJuros = txJuros;
    }

    public double getTxIof() {
        return txIof;
    }

    public void setTxIof(double txIof) {
        this.txIof = txIof;
    }

    public double getTxIr() {
        return txIr;
    }

    public void setTxIr(double txIr) {
        this.txIr = txIr;
    }

    @Override
    public int getCdConta() {
        return cdConta;
    }

    @Override
    public void setCdConta(int cdConta) {
        this.cdConta = cdConta;
    }

} //Fim da classe