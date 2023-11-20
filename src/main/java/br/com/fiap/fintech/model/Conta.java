package br.com.fiap.fintech.model;

public class Conta {

    private int cdConta;
    private long cnpjInstFinanc;
    private long cdCliente;
    private int cdAgencia;
    private String nrConta;
    private double valorSaldo;

    public Conta() {
    }


    //-------------------------------------------------------------------------------------------------------------------------------
    // Métodos Getters and Setters:


    public long getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(long cdCliente) {
        this.cdCliente = cdCliente;
    }

    public int getCdConta() {
        return cdConta;
    }

    public void setCdConta(int cdConta) {
        this.cdConta = cdConta;
    }

    public long getCnpjInstFinanc() {
        return cnpjInstFinanc;
    }

    public void setCnpjInstFinanc(long cnpjInstFinanc) {
        this.cnpjInstFinanc = cnpjInstFinanc;
    }


    public int getCdAgencia() {
        return cdAgencia;
    }

    public void setCdAgencia(int cdAgencia) {
        this.cdAgencia = cdAgencia;
    }

    public String getNrConta() {
        return nrConta;
    }

    public void setNrConta(String nrConta) {
        this.nrConta = nrConta;
    }

    public double getValorSaldo() {
        return valorSaldo;
    }

    public void setValorSaldo(double valorSaldo) {
        this.valorSaldo = valorSaldo;
    }

}
