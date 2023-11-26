package com.api.projetoupcycle.models;

import jakarta.persistence.*;

@Entity
@Table(name = "endereco_comum")
public class EnderecoComumModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_endereco_comum")
    private Long idEnderecoComum;

    @Column(name = "rua_comum")
    private String ruaComum;

    @Column(name = "estado_comum")
    private String estadoComum;

    @Column(name = "bairro_comum")
    private String bairroComum;

    @Column(name = "cidade_comum")
    private String cidadeComum;

    @Column(name = "uf_comum")
    private String ufComum;

    @Column(name = "complemento_comum")
    private String complementoComum;

    @Column(name = "numero_comum")
    private String numeroComum;

    @Column(name = "cep_comum")
    private String cepComum;

    public EnderecoComumModel(Long idEnderecoComum, String ruaComum, String numeroComum, String bairroComum, String cidadeComum, String estadoComum, String ufComum, String cepComum, String complementoComum) {
        this.idEnderecoComum = idEnderecoComum;
        this.ruaComum = ruaComum;
        this.numeroComum = numeroComum;
        this.bairroComum = bairroComum;
        this.cidadeComum = cidadeComum;
        this.estadoComum = estadoComum;
        this.ufComum = ufComum;
        this.cepComum = cepComum;
        this.complementoComum = complementoComum;
    }

    // Getters e Setters

    public Long getIdEnderecoComum() {
        return idEnderecoComum;
    }

    public void setIdEnderecoComum(Long idEnderecoComum) {
        this.idEnderecoComum = idEnderecoComum;
    }

    public String getRuaComum() {
        return ruaComum;
    }

    public void setRuaComum (String ruaComum) {
        this.ruaComum = ruaComum;
    }

    public String getEstadoComum() {
        return estadoComum;
    }

    public void setEstadoComum(String estadoComum) {
        this.estadoComum = estadoComum;
    }

    public String getBairroComum() {
        return bairroComum;
    }

    public void setBairroComum(String bairroComum) {
        this.bairroComum = bairroComum;
    }

    public String getCidadeComum() {
        return cidadeComum;
    }

    public void setCidadeComum(String cidadeComum) {
        this.cidadeComum = cidadeComum;
    }

    public String getUfComum() {
        return ufComum;
    }

    public void setUfComum(String ufComum) {
        this.ufComum = ufComum;
    }

    public String getComplementoComum() {
        return complementoComum;
    }

    public void setComplementoComum(String complementoComum) {
        this.complementoComum = complementoComum;
    }

    public String getNumeroComum() {
        return numeroComum;
    }

    public void setNumeroComum(String numeroComum) {
        this.numeroComum = numeroComum;
    }

    public String getCepComum() {
        return cepComum;
    }

    public void setCepComum(String cepComum) {
        this.cepComum = cepComum;
    }

    // Construtores
    public EnderecoComumModel() {
        super();
    }


}
