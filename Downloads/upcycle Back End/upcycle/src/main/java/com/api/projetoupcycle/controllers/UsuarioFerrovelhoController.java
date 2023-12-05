package com.api.projetoupcycle.controllers;

import com.api.projetoupcycle.DTO.LoginRequestDTO;
import com.api.projetoupcycle.models.UsuarioFerrovelho;
import com.api.projetoupcycle.services.UsuarioFerrovelhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/usuarios/ferrovelho")
public class UsuarioFerrovelhoController {

    public final UsuarioFerrovelhoService usuarioFerrovelhoService;

    @Autowired
    public UsuarioFerrovelhoController(UsuarioFerrovelhoService usuarioFerrovelhoService){
        this.usuarioFerrovelhoService = usuarioFerrovelhoService;
    }

    //OK
    @GetMapping
    public List<UsuarioFerrovelho> geteAllFerrovelhos(){
        return usuarioFerrovelhoService.geteAllFerrovelhos();
    }

    //OK
    @GetMapping("/{idFerrovelho}")
    public ResponseEntity<?> getFerrovelhoById(@PathVariable Long idFerrovelho){
        UsuarioFerrovelho umUsuarioFerrovelho = usuarioFerrovelhoService.getFerrovelhoById(idFerrovelho);
        if (umUsuarioFerrovelho != null){
            return ResponseEntity.ok(umUsuarioFerrovelho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //OK
    @PostMapping("/cadastro")
    public ResponseEntity<Object> novoUsuarioFerrovelho(@RequestBody UsuarioFerrovelho usuarioFerrovelho){
        try {
            UsuarioFerrovelho novoUsuario = usuarioFerrovelhoService.createUsuarioFerrovelho(usuarioFerrovelho);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
        } catch (RuntimeException e) {
            if (e.getCause() instanceof DataIntegrityViolationException) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao cadastrar ferro-velho: O CNPJ já está cadastrado.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
            }
        }
    }

    //OK
    @PutMapping("/{idFerrovelho}")
    public ResponseEntity<?> updateUsuarioFerrovelho(@PathVariable Long idFerrovelho, @RequestBody UsuarioFerrovelho usuarioFerrovelho){
        try {
            UsuarioFerrovelho usuarioFerrovelhoAtualizado = usuarioFerrovelhoService.updateUsuarioFerrovelho(idFerrovelho, usuarioFerrovelho);
            if (usuarioFerrovelhoAtualizado != null){
                return ResponseEntity.ok(usuarioFerrovelhoAtualizado);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ferrovelho não encontrado");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
    }

    //OK
    @DeleteMapping("/{idFerrovelho}")
    public ResponseEntity<?> deleteUsuarioFerrovelho(@PathVariable Long idFerrovelho) {
        try {
            boolean deletado = usuarioFerrovelhoService.deleteUsuarioFerrovelho(idFerrovelho);

            if (deletado){
                return ResponseEntity.ok(deletado);

            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário ferrovelho não encontrado.");
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro interno no servidor");
        }
    }

    //OK
    @PostMapping("/login")
    public ResponseEntity<?> verificarCredenciais(@RequestBody LoginRequestDTO loginRequestDTO){
        String cnpj = loginRequestDTO.getCnpj();
        String senha = loginRequestDTO.getSenha();

        boolean credenciaisValidas = usuarioFerrovelhoService.verificarCredenciais(cnpj, senha);

        if (credenciaisValidas){
            return ResponseEntity.ok().build();
        } else {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
        }
    }
}
