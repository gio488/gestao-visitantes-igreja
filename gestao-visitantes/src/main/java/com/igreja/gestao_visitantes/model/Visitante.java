package com.igreja.gestao_visitantes.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.time.LocalDate;

@Entity
@Data
public class Visitante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String cidade;
    private boolean evangelico;

    private LocalDate dataVisita = LocalDate.now();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitante_id")
    private List<Familiar> familiares;
}