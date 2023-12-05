package com.api.projetoupcycle.repositories;

import com.api.projetoupcycle.models.CadastroComumModel;
import com.api.projetoupcycle.models.EnderecoComumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@EnableJpaRepositories
@Repository

public interface CadastroComumRepository extends JpaRepository<CadastroComumModel, Long> {
    boolean existsByEmailComum(String emailComum);

    Optional<CadastroComumModel> findOneByEmailComumAndSenhaComum(String emailComum, String senhaComum); //CadastroComum

    CadastroComumModel findByEmailComum(String emailComum);

}
