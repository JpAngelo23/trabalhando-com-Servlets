package br.com.fiap.fintech.model;

public class CPoupanca extends Conta {

    //private int cdConta;
    private double txRendimento;


//------------------------------------------------------------------------
    // Métodos Getters and Setters:


//    @Override
//    public int getCdConta() {
//        return cdConta;
//    }
//
//    @Override
//    public void setCdConta(int cdConta) {
//        this.cdConta = cdConta;
//    }

    public double getTxRendimento() {
        return txRendimento;
    }

    public void setTxRendimento(double txRendimento) {
        this.txRendimento = txRendimento;
    }

} //Fim da classe