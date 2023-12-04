package com.api.projetoupcycle.controllers;


import com.api.projetoupcycle.models.EnderecoFerrovelho;
import com.api.projetoupcycle.services.EnderecoFerrovelhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/enderecos/ferrovelho")
public class EnderecoFerrovelhoController {

    private final EnderecoFerrovelhoService enderecoFerrovelhoService;

    @Autowired
    public EnderecoFerrovelhoController(EnderecoFerrovelhoService enderecoFerrovelhoService){
        this.enderecoFerrovelhoService = enderecoFerrovelhoService;
    }

    //OK
    @GetMapping
    public List<EnderecoFerrovelho> getAllEnderecos(){
        return enderecoFerrovelhoService.getAllEnderecos();
    }

    //OK
    @GetMapping("/especifico/{idEnderecoferrovelho}")
    public ResponseEntity<?> getEnderecoById(@PathVariable Long idEnderecoferrovelho){
        EnderecoFerrovelho oneEnderecoFerrovelho = enderecoFerrovelhoService.getEnderecoById(idEnderecoferrovelho);
        if (oneEnderecoFerrovelho != null){
            return ResponseEntity.ok(oneEnderecoFerrovelho);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //OK
    @PostMapping("/cadastro")
    public ResponseEntity<?> createEnderecoFerrovelho(@RequestBody EnderecoFerrovelho enderecoFerrovelho){
        try {
           EnderecoFerrovelho novoEnderecoFerrovelho = enderecoFerrovelhoService.createEnderecoFerrovelho(enderecoFerrovelho);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoEnderecoFerrovelho);
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar endereço: " + e.getMessage());
        }
    }

    //OK
    @PutMapping("/{idEnderecoferrovelho}")
    public ResponseEntity<?> updateEnderecoFerrovelho(@PathVariable Long idEnderecoferrovelho, @RequestBody EnderecoFerrovelho enderecoFerrovelho){
        try {
            EnderecoFerrovelho enderecoFerrovelhoAtualizado = enderecoFerrovelhoService.updateEnderecoFerrovelho(idEnderecoferrovelho, enderecoFerrovelho);
            if (enderecoFerrovelhoAtualizado != null){
                return ResponseEntity.ok(enderecoFerrovelhoAtualizado);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endereço não encontrado");
            }
        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar endereço: " + e.getMessage());
        }
    }

    //OK
    @DeleteMapping("/{idEnderecoferrovelho}")
    public ResponseEntity<?> deleteEnderecoFerrovelho(@PathVariable Long idEnderecoferrovelho){
        try {
            boolean deletado = enderecoFerrovelhoService.deleteEnderecoFerrovelho(idEnderecoferrovelho);
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
