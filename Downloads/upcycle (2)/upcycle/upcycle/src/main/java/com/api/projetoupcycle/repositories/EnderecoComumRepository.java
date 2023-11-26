package com.api.projetoupcycle.repositories;

import com.api.projetoupcycle.models.EnderecoComumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoComumRepository extends JpaRepository <EnderecoComumModel, Long> {
}
