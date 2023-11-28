package com.api.projetoupcycle.repositories;

import com.api.projetoupcycle.models.EnderecoFerrovelho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoFerrovelhoRepository extends JpaRepository<EnderecoFerrovelho, Long> {
}
