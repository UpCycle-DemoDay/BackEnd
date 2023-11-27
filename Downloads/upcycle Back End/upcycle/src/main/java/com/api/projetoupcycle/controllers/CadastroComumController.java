package com.api.projetoupcycle.controllers;

import com.api.projetoupcycle.DTO.Login2RequestDTO;
import com.api.projetoupcycle.models.CadastroComumModel;
import com.api.projetoupcycle.services.CadastroComumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class CadastroComumController {

    private final CadastroComumService cadastroComumService;

    @Autowired
    public CadastroComumController(CadastroComumService cadastroComumService){
        this.cadastroComumService = cadastroComumService;
    }

    //TESTE OK
    @GetMapping
    public List<CadastroComumModel> getAllCadastros(){
        return cadastroComumService.getAllCadastros();
    }

    //TESTE OK
    @GetMapping("/cliente-especifico/{idClienteComum}")
    public ResponseEntity<Object> getClienteComumById(@PathVariable Long idClienteComum){
        CadastroComumModel cadastroComumModel = cadastroComumService.getClienteComumById(idClienteComum);

        if (cadastroComumModel != null) {
            return ResponseEntity.ok(cadastroComumModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    //TESTE OK
    @PostMapping("/cadastrar")
    public ResponseEntity<?> novoCadastroComum(@Validated @RequestBody CadastroComumModel cadastroComumModel){
        try {
         CadastroComumModel novoUsuario = cadastroComumService.createCadastroComum(cadastroComumModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (RuntimeException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
    }

    //TESTE OK
    //Atualizar
    @PutMapping("/{idClienteComum}")
    public ResponseEntity<?> atualizarCadastroComum(@PathVariable Long idClienteComum, @RequestBody CadastroComumModel cadastroComumModel) {
        try {
            CadastroComumModel cadastroAtualizado = cadastroComumService.atualizarCadastroClienteComum(idClienteComum, cadastroComumModel);
            if (cadastroAtualizado != null) {
                return ResponseEntity.ok(cadastroAtualizado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ferrovelho não encontrado");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
    }

    //TESTE OK
    // Apagar
    @DeleteMapping("/{idClienteComum}")
    public ResponseEntity<?> deletarCadastroPessoa(@PathVariable Long idClienteComum){
        try {
            boolean deletado = cadastroComumService.deletarCadastroClienteComum(idClienteComum);

            if (deletado){
                return ResponseEntity.ok(deletado);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ferrovelho não encontrado.");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
    }

    // TESTE OK
   @PostMapping("/login")
    public ResponseEntity<?> verificarCredenciais(@RequestBody Login2RequestDTO loginRequestDTO){
        String cpf = loginRequestDTO.getCpf();
        String senha = loginRequestDTO.getSenha();

        boolean credenciaisValidas = cadastroComumService.verificarCredenciais(cpf, senha);

        if (credenciaisValidas){
            return ResponseEntity.ok().build(); //HTTP 204 No Content, que indica sucesso sem conteúdo no corpo da resposta.
        } else {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
}