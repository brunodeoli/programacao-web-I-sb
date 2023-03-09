package br.com.ada.locatecar.model.types;

public class Endereco {
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(String endereco, String numero, String complemento, String bairro, String cidade, String estado, String pais) {
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return endereco + ", "
                + numero + ", "
                + complemento + ", "
                + bairro + ". "
                + cidade + " - "
                + estado + " - "
                + pais;
    }
}
