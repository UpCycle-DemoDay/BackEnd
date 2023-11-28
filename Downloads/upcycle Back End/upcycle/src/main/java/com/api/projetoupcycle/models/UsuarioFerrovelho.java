package com.api.projetoupcycle.models;


import jakarta.persistence.*;

@Entity
@Table(name = "cadastroFerrovelho")
public class UsuarioFerrovelho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_ferrovelho")
    private Long idFerrovelho;

    @Column(name = "nome_ferrovelho")
    private String nomeFerrovelho;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "email_ferrovelho")
    private String emailFerrovelho;

    @Column(name = "telefone_ferrovelho")
    private String telefoneFerrovelho;

    @Column(name = "descricao_materiais")
    private String descricaoMateriais;

    @Column(name = "senha_ferrovelho")
    private String senhaFerrovelho;

    @ManyToOne
    @JoinColumn(name = "id_enderecoferrovelho")
    private EnderecoFerrovelho enderecoFerrovelho;

    public UsuarioFerrovelho() {
    }

    public UsuarioFerrovelho(Long idFerrovelho, String nomeFerrovelho, String cnpj, String emailFerrovelho, String telefoneFerrovelho, String descricaoMateriais, String senhaFerrovelho, EnderecoFerrovelho enderecoFerrovelho) {
        this.idFerrovelho = idFerrovelho;
        this.nomeFerrovelho = nomeFerrovelho;
        this.cnpj = cnpj;
        this.emailFerrovelho = emailFerrovelho;
        this.telefoneFerrovelho = telefoneFerrovelho;
        this.descricaoMateriais = descricaoMateriais;
        this.senhaFerrovelho = senhaFerrovelho;
        this.enderecoFerrovelho = enderecoFerrovelho;
    }

    public Long getIdFerrovelho() {
        return idFerrovelho;
    }

    public void setIdFerrovelho(Long idFerrovelho) {
        this.idFerrovelho = idFerrovelho;
    }

    public String getNomeFerrovelho() {
        return nomeFerrovelho;
    }

    public void setNomeFerrovelho(String nomeFerrovelho) {
        this.nomeFerrovelho = nomeFerrovelho;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmailFerrovelho() {
        return emailFerrovelho;
    }

    public void setEmailFerrovelho(String emailFerrovelho) {
        this.emailFerrovelho = emailFerrovelho;
    }

    public String getTelefoneFerrovelho() {
        return telefoneFerrovelho;
    }

    public void setTelefoneFerrovelho(String telefoneFerrovelho) {
        this.telefoneFerrovelho = telefoneFerrovelho;
    }

    public String getDescricaoMateriais() {
        return descricaoMateriais;
    }

    public void setDescricaoMateriais(String descricaoMateriais) {
        this.descricaoMateriais = descricaoMateriais;
    }

    public String getSenhaFerrovelho() {
        return senhaFerrovelho;
    }

    public void setSenhaFerrovelho(String senhaFerrovelho) {
        this.senhaFerrovelho = senhaFerrovelho;
    }

    public EnderecoFerrovelho getEnderecoFerrovelho() {
        return enderecoFerrovelho;
    }

    public void setEnderecoFerrovelho(EnderecoFerrovelho enderecoFerrovelho) {
        this.enderecoFerrovelho = enderecoFerrovelho;
    }
}
