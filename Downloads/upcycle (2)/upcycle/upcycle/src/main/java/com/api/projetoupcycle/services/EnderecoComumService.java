package com.api.projetoupcycle.services;


import com.api.projetoupcycle.models.EnderecoComumModel;
import com.api.projetoupcycle.repositories.EnderecoComumRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoComumService {

    private EnderecoComumRepository enderecoComumRepository;

    @Autowired
    public EnderecoComumService(EnderecoComumRepository enderecoComumRepository) {
        this.enderecoComumRepository = enderecoComumRepository;
    }

    //Todos os endereços ok
    public List<EnderecoComumModel> getAllEnderecos() {
        return enderecoComumRepository.findAll();
    }

    //Endereço por id ok
    public EnderecoComumModel getEnderecoById(Long idEnderecoComum) {
        return enderecoComumRepository.findById(idEnderecoComum).orElse(null);
    }

    // Cadastrar/criar
    public EnderecoComumModel createEnderecoComum(EnderecoComumModel enderecoComumModel) {
        this.validarEndereco(enderecoComumModel);
        return enderecoComumRepository.save(enderecoComumModel);
    }

    private void validarEndereco(@NotNull EnderecoComumModel enderecoComumModel) {
        this.validarCampo(enderecoComumModel.getRuaComum(), "O nome da rua não pode ser vazio.");
        this.validarCampo(enderecoComumModel.getNumeroComum(), "O número do endereço não pode ser vazio.");
        this.validarCampo(enderecoComumModel.getBairroComum(), "O nome do bairro não pode ser vazio.");
        this.validarCampo(enderecoComumModel.getCidadeComum(), "O nome da cidade não pode ser vazio.");
        this.validarCampo(enderecoComumModel.getEstadoComum(), "O nome do estado não pode ser vazio.");
        this.validarCampo(enderecoComumModel.getUfComum(), "A UF não pode ser vazia.");
        this.validarCampo(enderecoComumModel.getCepComum(), "O CEP não pode ser vazio");
    }

    private void validarCampo(String valor, String mensagemErro) {
        if (valor == null || valor.isEmpty()) {
            throw new RuntimeException(mensagemErro);
        }
    }

    //Atualizar
    public EnderecoComumModel atualizarEndereco(Long idEnderecoComum, EnderecoComumModel enderecoComumModel) {
        EnderecoComumModel enderecoExistente = enderecoComumRepository.findById(idEnderecoComum).orElse(null);

        if (enderecoExistente != null) {

            enderecoExistente.setRuaComum(enderecoComumModel.getRuaComum());
            enderecoExistente.setNumeroComum(enderecoComumModel.getNumeroComum());
            enderecoExistente.setBairroComum(enderecoComumModel.getBairroComum());
            enderecoExistente.setCidadeComum(enderecoComumModel.getCidadeComum());
            enderecoExistente.setEstadoComum(enderecoComumModel.getEstadoComum());
            enderecoExistente.setUfComum(enderecoComumModel.getUfComum());
            enderecoExistente.setCepComum(enderecoComumModel.getCepComum());

            return enderecoComumRepository.save(enderecoExistente);
        } else {
            return null;
        }
    }

    public boolean deletarEndereco(Long idEnderecoFerrovelho) {
        EnderecoComumModel enderecoExistente = enderecoComumRepository.findById(idEnderecoFerrovelho).orElse(null);

        if (enderecoExistente != null) {
            enderecoComumRepository.delete(enderecoExistente);
            return true;
        } else {
            return false;
        }
    }
}

