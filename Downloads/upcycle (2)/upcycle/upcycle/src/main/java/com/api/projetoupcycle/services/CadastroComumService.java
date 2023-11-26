package com.api.projetoupcycle.services;

import com.api.projetoupcycle.models.CadastroComumModel;
import com.api.projetoupcycle.repositories.CadastroComumRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroComumService {

    private CadastroComumRepository cadastroComumRepository;

    @Autowired
    public CadastroComumService(CadastroComumRepository cadastroComumRepository) {
        this.cadastroComumRepository = cadastroComumRepository;
    }

    //Listar todos
    public List<CadastroComumModel> getAllCadastros() {
        return cadastroComumRepository.findAll();
    }

    //Pega o cliente pelo id
    public CadastroComumModel getClienteComumById(Long idClienteComum) {
        return cadastroComumRepository.findById(idClienteComum).orElse(null);
    }

    //Cadastrar/novo
    public CadastroComumModel createCadastroComum(CadastroComumModel cadastroComumModel) {
        this.verificarDuplicidade(cadastroComumModel);

        try {
            return cadastroComumRepository.save(cadastroComumModel);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao criar cadastro de ferrovelho. O CNPJ já está cadastrado.", e);
        }
    }

    private void verificarDuplicidade(@NotNull CadastroComumModel cadastroComumModel) {
        if (cadastroComumRepository.findByCpfComum(cadastroComumModel.getCpfComum()) != null) {
            throw new RuntimeException("CPF já cadastrado.");
        }
    }

    //Atualizar - id e cnpj não são atualizados
    public CadastroComumModel atualizarCadastroClienteComum(Long idClienteComum, CadastroComumModel cadastroComumModel) {
        CadastroComumModel cadastroExistente = cadastroComumRepository.findById(idClienteComum).orElse(null);

        if (cadastroExistente != null) {

            // Mantém o ID e o CNPJ inalterados
            cadastroExistente.setIdClienteComum(idClienteComum);
            cadastroExistente.setCpfComum(cadastroComumModel.getCpfComum());
            cadastroExistente.setEmailComum(cadastroComumModel.getEmailComum());
            cadastroExistente.setTelefoneComum(cadastroComumModel.getTelefoneComum());
            cadastroExistente.setEmailComum(cadastroComumModel.getEmailComum());
            cadastroExistente.setDataNascimentoComum(cadastroComumModel.getDataNascimentoComum());
            cadastroExistente.setSenhaComum(cadastroComumModel.getSenhaComum());
            cadastroExistente.setEnderecoComumModel(cadastroComumModel.getEnderecoComumModel());

            return cadastroComumRepository.save(cadastroExistente);
        } else {
            return null;
        }
    }

    // Deleta um existente
    public boolean deletarCadastroClienteComum(Long idClienteComum) {
        CadastroComumModel cadastroClienteComumExistente = cadastroComumRepository.findById(idClienteComum).orElse(null);

        if (cadastroClienteComumExistente != null) {
            cadastroComumRepository.delete(cadastroClienteComumExistente);
            return true;
        } else {
            return false;
        }
    }

    //Verificar
    public boolean verificarCpf(String cpf){
        CadastroComumModel usuario = cadastroComumRepository.findByCpfComum(cpf);
        return usuario != null;
    }

    public boolean verificarCredenciais(String cpf, String senha){
        boolean cpfEmUso =  verificarCpf(cpf);
        if (cpfEmUso){
            CadastroComumModel usuario = cadastroComumRepository.findByCpfComum(cpf);
            if (senha.equals(usuario.getSenhaComum())){
                return true;
            }
        }
        return false;
    }
}

