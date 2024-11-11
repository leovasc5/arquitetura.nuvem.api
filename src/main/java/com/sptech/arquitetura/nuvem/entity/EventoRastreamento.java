package com.sptech.arquitetura.nuvem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EventoRastreamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_entrega", nullable = false)
    private Entrega entrega;

    @Column(nullable = false, length = 50)
    private String status;

    @Column(name = "data_evento", nullable = false, updatable = false)
    private LocalDateTime dataEvento = LocalDateTime.now();

    @Column(length = 255)
    private String localizacao;

    @Column(length = 255)
    private String descricao;

}
