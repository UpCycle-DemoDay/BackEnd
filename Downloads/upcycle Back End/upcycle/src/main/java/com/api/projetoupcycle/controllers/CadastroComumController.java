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
@CrossOrigin(origins = "*")
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
    @GetMapping("/usuario/{idClienteComum}")
    public ResponseEntity<Object> getClienteComumById(@PathVariable Long idClienteComum){
        CadastroComumModel cadastroComumModel = cadastroComumService.getClienteComumById(idClienteComum);

        if (cadastroComumModel != null) {
            return ResponseEntity.ok(cadastroComumModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //TESTE OK
    @PostMapping("/cadastro")
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
        String emailComum = loginRequestDTO.getEmail();
        String senha = loginRequestDTO.getSenha();

        boolean credenciaisValidas = cadastroComumService.verificarCredenciais(emailComum, senha);

        if (credenciaisValidas){
            return ResponseEntity.ok().build();
        } else {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
}