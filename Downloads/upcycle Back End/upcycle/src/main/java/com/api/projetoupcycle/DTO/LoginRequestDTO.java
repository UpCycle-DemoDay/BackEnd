package com.api.projetoupcycle.DTO;

//Espera o input do usuário

public class LoginRequestDTO {

    private String cnpj;
    private String senha;

    public LoginRequestDTO(String cnpj, String senha) {
        this.cnpj = cnpj;
        this.senha = senha;
    }

    public LoginRequestDTO() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
