package com.igreja.gestao_visitantes.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Familiar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String parentesco;
    private boolean evangelico;
    private String nomeIgreja;
    private LocalDate dataVisita;
}
