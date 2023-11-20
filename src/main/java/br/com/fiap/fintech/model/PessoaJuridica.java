package br.com.fiap.fintech.model;

public class PessoaJuridica extends Cliente {

    private long cdCliente;
    private long cnpj;
    private String dsInscricaoMunic;


  //---------------------------------
  // Getters and Setters:

    public long getCdCliente() {
        return cdCliente;
    }

    public void setCdCliente(long cdCliente) {
        this.cdCliente = cdCliente;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getDsInscricaoMunic() {
        return dsInscricaoMunic;
    }

    public void setDsInscricaoMunic(String dsInscricaoMunic) {
        this.dsInscricaoMunic = dsInscricaoMunic;
    }
}
