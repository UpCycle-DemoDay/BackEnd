package com.api.projetoupcycle.models;


import jakarta.persistence.*;

@Entity
@Table(name = "enderecoFerrovelho")
public class EnderecoFerrovelho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_enderecoferrovelho")
    private Long idEnderecoferrovelho;

    @Column(name = "rua_ferrovelho")
    private String ruaFerrovelho;

    @Column(name = "numero_ferrovelho")
    private String numeroFerrovelho;

    @Column(name = "bairro_ferrovelho")
    private String bairroFerrovelho;

    @Column(name = "cidade_ferrovelho")
    private String cidadeFerrovelho;

    @Column(name = "estado_ferrovelho")
    private String estadoFerrovelho;

    @Column(name = "uf_ferrovelho")
    private String ufFerrovelho;

    @Column(name = "cep_ferrovelho")
    private String  cepFerrovelho;

    @Column(name = "complemento_ferrovelho")
    private String complementoFerrovelho;

    public EnderecoFerrovelho() {
    }

    public EnderecoFerrovelho(Long idEnderecoferrovelho, String ruaFerrovelho, String numeroFerrovelho, String bairroFerrovelho, String cidadeFerrovelho, String estadoFerrovelho, String ufFerrovelho, String cepFerrovelho, String complementoFerrovelho) {
        this.idEnderecoferrovelho = idEnderecoferrovelho;
        this.ruaFerrovelho = ruaFerrovelho;
        this.numeroFerrovelho = numeroFerrovelho;
        this.bairroFerrovelho = bairroFerrovelho;
        this.cidadeFerrovelho = cidadeFerrovelho;
        this.estadoFerrovelho = estadoFerrovelho;
        this.ufFerrovelho = ufFerrovelho;
        this.cepFerrovelho = cepFerrovelho;
        this.complementoFerrovelho = complementoFerrovelho;
    }

    public Long getIdEnderecoferrovelho() {
        return idEnderecoferrovelho;
    }

    public void setIdEnderecoferrovelho(Long idEnderecoferrovelho) {
        this.idEnderecoferrovelho = idEnderecoferrovelho;
    }

    public String getRuaFerrovelho() {
        return ruaFerrovelho;
    }

    public void setRuaFerrovelho(String ruaFerrovelho) {
        this.ruaFerrovelho = ruaFerrovelho;
    }

    public String getNumeroFerrovelho() {
        return numeroFerrovelho;
    }

    public void setNumeroFerrovelho(String numeroFerrovelho) {
        this.numeroFerrovelho = numeroFerrovelho;
    }

    public String getBairroFerrovelho() {
        return bairroFerrovelho;
    }

    public void setBairroFerrovelho(String bairroFerrovelho) {
        this.bairroFerrovelho = bairroFerrovelho;
    }

    public String getCidadeFerrovelho() {
        return cidadeFerrovelho;
    }

    public void setCidadeFerrovelho(String cidadeFerrovelho) {
        this.cidadeFerrovelho = cidadeFerrovelho;
    }

    public String getEstadoFerrovelho() {
        return estadoFerrovelho;
    }

    public void setEstadoFerrovelho(String estadoFerrovelho) {
        this.estadoFerrovelho = estadoFerrovelho;
    }

    public String getUfFerrovelho() {
        return ufFerrovelho;
    }

    public void setUfFerrovelho(String ufFerrovelho) {
        this.ufFerrovelho = ufFerrovelho;
    }

    public String getCepFerrovelho() {
        return cepFerrovelho;
    }

    public void setCepFerrovelho(String cepFerrovelho) {
        this.cepFerrovelho = cepFerrovelho;
    }

    public String getComplementoFerrovelho() {
        return complementoFerrovelho;
    }

    public void setComplementoFerrovelho(String complementoFerrovelho) {
        this.complementoFerrovelho = complementoFerrovelho;
    }
}
