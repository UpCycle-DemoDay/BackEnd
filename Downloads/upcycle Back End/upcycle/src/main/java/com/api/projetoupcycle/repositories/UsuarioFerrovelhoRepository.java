package com.api.projetoupcycle.repositories;

import com.api.projetoupcycle.models.UsuarioFerrovelho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UsuarioFerrovelhoRepository extends JpaRepository<UsuarioFerrovelho, Long> {
    boolean existsByCnpj(String cnpj);

    Optional<UsuarioFerrovelho> findOneByCnpjAndSenhaFerrovelho(String cnpj, String senha);//Ferrovelho

    UsuarioFerrovelho findByCnpj(String cnpj);
}
