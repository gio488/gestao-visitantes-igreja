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

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nomeIgreja;

    private boolean evangelico;

    private LocalDate dataVisita = LocalDate.now();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "visitante_id")
    private List<Familiar> familiares;

    public LocalDate getDataVisita() {
        return dataVisita;
    }
}