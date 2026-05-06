package com.igreja.gestao_visitantes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Familiar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String parentesco;
}
