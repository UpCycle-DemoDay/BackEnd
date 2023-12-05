package com.api.projetoupcycle.services;

import com.api.projetoupcycle.models.UsuarioFerrovelho;
import com.api.projetoupcycle.repositories.UsuarioFerrovelhoRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioFerrovelhoService {

    private UsuarioFerrovelhoRepository usuarioFerrovelhoRepository;

    @Autowired
    public UsuarioFerrovelhoService (UsuarioFerrovelhoRepository usuarioFerrovelhoRepository){
        this.usuarioFerrovelhoRepository = usuarioFerrovelhoRepository;
    }

    //Listar todos
    public List<UsuarioFerrovelho> geteAllFerrovelhos(){
        return usuarioFerrovelhoRepository.findAll();
    }

    //Pegar por id
    public UsuarioFerrovelho getFerrovelhoById(Long idFerrovelho){
        return usuarioFerrovelhoRepository.findById(idFerrovelho).orElse(null);
    }

    //Cadastrar/criar
    public UsuarioFerrovelho createUsuarioFerrovelho(UsuarioFerrovelho usuarioFerrovelho) {
        verificarDuplicidade(usuarioFerrovelho);

        try {
            return usuarioFerrovelhoRepository.save(usuarioFerrovelho);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Erro ao criar usuário. CNPJ já cadastrado.", e);
        }
    }

    private void verificarDuplicidade(@NotNull UsuarioFerrovelho cadastroFerrovelho) {
        if (usuarioFerrovelhoRepository.existsByCnpj(cadastroFerrovelho.getCnpj())) {
            throw new RuntimeException("CNPJ já cadastrado.");
        }
    }

    //Atualizar - id e cnpj não são atualizados
    public UsuarioFerrovelho updateUsuarioFerrovelho(Long idFerrovelho, UsuarioFerrovelho usuarioFerrovelho){
        UsuarioFerrovelho usuarioExistente = usuarioFerrovelhoRepository.findById(idFerrovelho).orElse(null);
        if (usuarioExistente != null){
            // Mantém o ID e o CNPJ inalterados
            usuarioFerrovelho.setIdFerrovelho(idFerrovelho);
            usuarioFerrovelho.setCnpj(usuarioExistente.getCnpj());

            usuarioExistente.setEmailFerrovelho(usuarioFerrovelho.getEmailFerrovelho());
            usuarioExistente.setTelefoneFerrovelho(usuarioFerrovelho.getTelefoneFerrovelho());
            usuarioExistente.setDescricaoMateriais(usuarioFerrovelho.getDescricaoMateriais());
            usuarioExistente.setEnderecoFerrovelho(usuarioFerrovelho.getEnderecoFerrovelho()); //Olhar esse aqui
            usuarioExistente.setSenhaFerrovelho(usuarioFerrovelho.getSenhaFerrovelho());
            return usuarioFerrovelhoRepository.save(usuarioFerrovelho);
        } else {
            return null;
        }
    }


    //Deleta usuário
    public boolean deleteUsuarioFerrovelho(Long idFerrovelho) {
        UsuarioFerrovelho cadastroFerrovelhoExistente = usuarioFerrovelhoRepository.findById(idFerrovelho).orElse(null);

        if (cadastroFerrovelhoExistente != null) {
            usuarioFerrovelhoRepository.delete(cadastroFerrovelhoExistente);
            return true;
        } else {
            return false;
        }
    }

    //Verificar
    public boolean verificarCnpj(String cnpj){
        UsuarioFerrovelho usuario = usuarioFerrovelhoRepository.findByCnpj(cnpj);
        return usuario != null;
    }

    public boolean verificarCredenciais(String cnpj, String senha){
        boolean cnpjEmUso =  verificarCnpj(cnpj);
        if (cnpjEmUso){
            UsuarioFerrovelho usuario = usuarioFerrovelhoRepository.findByCnpj(cnpj);
            if (senha.equals(usuario.getSenhaFerrovelho())){
                return true;
            }
        }
        return false;
    }

}
