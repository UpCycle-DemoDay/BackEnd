package com.api.projetoupcycle.services;

import com.api.projetoupcycle.models.EnderecoFerrovelho;
import com.api.projetoupcycle.repositories.EnderecoFerrovelhoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnderecoFerrovelhoService {

    private EnderecoFerrovelhoRepository enderecoFerrovelhoRepository;

    @Autowired
    public EnderecoFerrovelhoService(EnderecoFerrovelhoRepository enderecoFerrovelhoRepository){
        this.enderecoFerrovelhoRepository = enderecoFerrovelhoRepository;
    }

    //Lista todos
    public List<EnderecoFerrovelho> getAllEnderecos(){
        return enderecoFerrovelhoRepository.findAll();
    }

    //Pega por id
    public EnderecoFerrovelho getEnderecoById(Long idEnderecoferrovelho){
        return enderecoFerrovelhoRepository.findById(idEnderecoferrovelho).orElse(null);
    }

    //Cadastrar/criar
    public EnderecoFerrovelho createEnderecoFerrovelho(EnderecoFerrovelho enderecoFerrovelho) {
        validarEndereco(enderecoFerrovelho);
        return enderecoFerrovelhoRepository.save(enderecoFerrovelho);
    }

    private void validarEndereco(@NotNull EnderecoFerrovelho enderecoFerrovelho) {
        validarCampo(enderecoFerrovelho.getRuaFerrovelho(), "O nome da rua não pode ser vazio.");
        validarCampo(enderecoFerrovelho.getNumeroFerrovelho(), "O número do endereço não pode ser vazio.");
        validarCampo(enderecoFerrovelho.getBairroFerrovelho(), "O nome do bairro não pode ser vazio.");
        validarCampo(enderecoFerrovelho.getCidadeFerrovelho(), "O nome da cidade não pode ser vazio.");
        validarCampo(enderecoFerrovelho.getEstadoFerrovelho(), "O nome do estado não pode ser vazio.");
        validarCampo(enderecoFerrovelho.getUfFerrovelho(), "A UF não pode ser vazia.");
        validarCampo(enderecoFerrovelho.getCepFerrovelho(), "O CEP não pode ser vazio");
    }

    private void validarCampo(String valor, String mensagemErro) {
        if (valor == null || valor.isEmpty()) {
            throw new RuntimeException(mensagemErro);
        }
    }

    //Atualizar
    public EnderecoFerrovelho updateEnderecoFerrovelho(Long idEnderecoferrovelho, EnderecoFerrovelho enderecoFerrovelho){
        EnderecoFerrovelho enderecoFerrovelhoExistente = enderecoFerrovelhoRepository.findById(idEnderecoferrovelho).orElse(null);
        if (enderecoFerrovelhoExistente != null){

            enderecoFerrovelhoExistente.setRuaFerrovelho(enderecoFerrovelho.getRuaFerrovelho());
            enderecoFerrovelhoExistente.setNumeroFerrovelho(enderecoFerrovelho.getNumeroFerrovelho());
            enderecoFerrovelhoExistente.setBairroFerrovelho(enderecoFerrovelho.getBairroFerrovelho());
            enderecoFerrovelhoExistente.setCidadeFerrovelho(enderecoFerrovelho.getCidadeFerrovelho());
            enderecoFerrovelhoExistente.setEstadoFerrovelho(enderecoFerrovelho.getEstadoFerrovelho());
            enderecoFerrovelhoExistente.setUfFerrovelho(enderecoFerrovelho.getUfFerrovelho());
            enderecoFerrovelhoExistente.setCepFerrovelho(enderecoFerrovelho.getCepFerrovelho());

            return enderecoFerrovelhoRepository.save(enderecoFerrovelhoExistente);
        } else {
            return null;
        }
    }

    //Deletar
    public boolean deleteEnderecoFerrovelho(Long idFerrovelho) {
        EnderecoFerrovelho enderecoFerrovelhoExistente = enderecoFerrovelhoRepository.findById(idFerrovelho).orElse(null);

        if (enderecoFerrovelhoExistente != null) {
            enderecoFerrovelhoRepository.delete(enderecoFerrovelhoExistente);
            return true;
        } else {
            return false;
        }
    }

}
