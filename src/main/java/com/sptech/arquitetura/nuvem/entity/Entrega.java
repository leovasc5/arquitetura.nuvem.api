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
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_rastreamento", nullable = false, unique = true, length = 50)
    private String numeroRastreamento;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "endereco_origem", nullable = false)
    private String enderecoOrigem;

    @Column(name = "endereco_destino", nullable = false)
    private String enderecoDestino;

    @Column(name = "data_criacao", nullable = false, updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "data_previsao_entrega")
    private LocalDateTime dataPrevisaoEntrega;

    @Column(nullable = false, length = 50)
    private String status = "PENDENTE";
}