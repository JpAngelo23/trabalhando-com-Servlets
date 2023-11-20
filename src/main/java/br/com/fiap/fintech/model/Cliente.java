package br.com.fiap.fintech.model;

public class Cliente extends Pessoa {

    private long cdCliente;
    private long cdPessoa;
    private String dsSenha;
    private String dsConta;
    private String email;


    // Métodos Construtores:
    // Construtor  Default
    public Cliente() {
    }

    //Construtor com recebimento de parâmetros
    public Cliente (int cdCliente, int cdPessoa, String dsSenha, String dsConta, String email){
        this.cdCliente = cdCliente;
        this.cdPessoa = cdPessoa;
        this.dsSenha = dsSenha;
        this.dsConta = dsConta;
        this.email = email;
    }

//------------------------------------------------------------------------
    // Métodos Getters and Setters:
    public long getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(long cdCliente) {
        this.cdCliente = cdCliente;
    }

    public long getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(long cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public String getDsConta() {
        return dsConta;
    }

    public void setDsConta(String dsConta) {
        this.dsConta = dsConta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
