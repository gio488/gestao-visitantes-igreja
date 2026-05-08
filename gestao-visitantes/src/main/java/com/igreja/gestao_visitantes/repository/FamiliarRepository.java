package com.igreja.gestao_visitantes.repository;

import com.igreja.gestao_visitantes.model.Familiar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliarRepository extends JpaRepository<Familiar, Long> {
}
