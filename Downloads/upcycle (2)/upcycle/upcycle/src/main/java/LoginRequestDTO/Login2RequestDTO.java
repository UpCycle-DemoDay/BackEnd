package LoginRequestDTO;

public class Login2RequestDTO {

    private String cpf;
    private String senha;

    public Login2RequestDTO(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }

    public Login2RequestDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
