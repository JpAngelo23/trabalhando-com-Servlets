package br.com.fiap.fintech.model;

public class PessoaFisica extends  Cliente {

    private long cdCliente;
    private long cdPessoa;
    private long cpf;
    private String nrRg;

// -----------------------------------------------------
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

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getNrRg() {
        return nrRg;
    }

    public void setNrRg(String nrRg) {
        this.nrRg = nrRg;
    }
} // FIM da classe
