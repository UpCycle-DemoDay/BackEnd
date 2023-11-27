package com.api.projetoupcycle.models;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente_comum")
public class CadastroComumModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente_comum")
    private Long idClienteComum;

    @Column(name = "nome_comum")
    private String nomeComum;

    @Column(name = "cpf_comum", unique = true)
    private String cpfComum;

    @Column(name = "telefone_comum")
    private String telefoneComum;

    @Column(name = "email_comum")
    private String emailComum;

    @Column(name = "data_nascimento_comum")
    private String dataNascimentoComum;

    @Column(name = "senha_comum")
    private String senhaComum;

    @ManyToOne
    @JoinColumn(name = "id_endereco_comum")
    private EnderecoComumModel enderecoComumModel;

    public Long getIdClienteComum() {
        return idClienteComum;
    }

    public void setIdClienteComum(Long idClienteComum) {
        this.idClienteComum = idClienteComum;
    }

    public String getNomeComum() {
        return nomeComum;
    }

    public void setNomeComum(String nomeComum) {
        this.nomeComum = nomeComum;
    }

    public String getCpfComum() {
        return cpfComum;
    }

    public void setCpfComum(String cpfComum) {
        this.cpfComum = cpfComum;
    }

    public String getTelefoneComum() {
        return telefoneComum;
    }

    public void setTelefoneComum(String telefoneComum) {
        this.telefoneComum = telefoneComum;
    }

    public String getEmailComum() {
        return emailComum;
    }

    public void setEmailComum(String emailComum) {
        this.emailComum = emailComum;
    }

    public String getDataNascimentoComum() {
        return dataNascimentoComum;
    }

    public void setDataNascimentoComum(String dataNascimentoComum) {
        this.dataNascimentoComum = dataNascimentoComum;
    }

    public String getSenhaComum() {
        return senhaComum;
    }

    public void setSenhaComum(String senhaComum) {
        this.senhaComum = senhaComum;
    }


    public EnderecoComumModel getEnderecoComumModel() {
        return enderecoComumModel;
    }

    public void setEnderecoComumModel(EnderecoComumModel enderecoComumModel) {
        this.enderecoComumModel = enderecoComumModel;
    }

    public CadastroComumModel() {
        super();
    }

    public CadastroComumModel(Long idClienteComum, String nomeComum, String cpfComum, String telefoneComum, String emailComum, String dataNascimentoComum, String senhaComum, String tokenSenhaComum, EnderecoComumModel enderecoComumModel) {
        this.idClienteComum = idClienteComum;
        this.nomeComum = nomeComum;
        this.cpfComum = cpfComum;
        this.telefoneComum = telefoneComum;
        this.emailComum = emailComum;
        this.dataNascimentoComum = dataNascimentoComum;
        this.senhaComum = senhaComum;
        this.enderecoComumModel = enderecoComumModel;
    }
}
