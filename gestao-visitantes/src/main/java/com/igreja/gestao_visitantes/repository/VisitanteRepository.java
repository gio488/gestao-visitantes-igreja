package com.igreja.gestao_visitantes.repository;

import com.igreja.gestao_visitantes.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {

}