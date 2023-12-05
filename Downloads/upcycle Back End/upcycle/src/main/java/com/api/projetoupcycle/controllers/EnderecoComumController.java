package com.api.projetoupcycle.controllers;

import com.api.projetoupcycle.models.EnderecoComumModel;
import com.api.projetoupcycle.services.EnderecoComumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enderecos-comum")
public class EnderecoComumController {

    private final EnderecoComumService enderecoComumService;

    @Autowired
    public EnderecoComumController(EnderecoComumService enderecoComumService){
        this.enderecoComumService = enderecoComumService;
    }

    // TESTE OK
    @GetMapping
    public List<EnderecoComumModel> getAllEnderecos(){
        return enderecoComumService.getAllEnderecos();
    }

    // TESTE OK
    @GetMapping("/especifico/{idEnderecoComum}")
    public ResponseEntity<?> getEnderecoById(@PathVariable Long idEnderecoComum){
        EnderecoComumModel oneEnderecoComumModel = enderecoComumService.getEnderecoById(idEnderecoComum);

        if (oneEnderecoComumModel != null){
            return ResponseEntity.ok(oneEnderecoComumModel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //TESTE OK
    @PostMapping("/cadastro") //cd ok
    public ResponseEntity<?> createEnderecoComum (@RequestBody EnderecoComumModel enderecoComumModel){
        try {
            EnderecoComumModel novoEndereco = enderecoComumService.createEnderecoComum(enderecoComumModel);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoEndereco);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar endereço: " + e.getMessage());
        }
    }

    //TESTE OK
    @PutMapping("/{idEnderecoComum}")
    public ResponseEntity<?> atualizarEndereco(@PathVariable Long idEnderecoComum, @RequestBody EnderecoComumModel enderecoComumModel){
        try {
            EnderecoComumModel enderecoAtualizado = enderecoComumService.atualizarEndereco(idEnderecoComum, enderecoComumModel);
            if (enderecoAtualizado != null){
                return ResponseEntity.ok(enderecoAtualizado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
            }
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar endereço: " + e.getMessage());
        }
    }

    // TESTE OK
    @DeleteMapping("/{idEnderecoComum}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long idEnderecoComum){
        try {
                boolean deletado = enderecoComumService.deletarEndereco(idEnderecoComum);
            if (deletado){
                return ResponseEntity.ok(deletado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
            }
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Endereço não encontrado" + e.getMessage());
        }
    }
}
