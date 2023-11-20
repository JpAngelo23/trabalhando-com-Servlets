package br.com.fiap.fintech.model;

public class Pessoa {

    private long cdPessoa;
    private String nomePessoa;
    private String cep;
    private String complemento;
    private long tel;


//-----------------------------
// Getters and Setters:

    public long getCdPessoa() {
        return cdPessoa;
    }

    public void setCdPessoa(long cdPessoa) {
        this.cdPessoa = cdPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }
}
