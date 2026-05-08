package com.igreja.gestao_visitantes.repository;

import com.igreja.gestao_visitantes.model.Informativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformativoRepository extends JpaRepository<Informativo, Long> {
}