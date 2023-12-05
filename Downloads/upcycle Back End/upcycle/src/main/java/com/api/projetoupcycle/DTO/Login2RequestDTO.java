package com.api.projetoupcycle.DTO;

public class Login2RequestDTO {

    private String email;
    private String senha;

    public Login2RequestDTO() {
    }

    public Login2RequestDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
