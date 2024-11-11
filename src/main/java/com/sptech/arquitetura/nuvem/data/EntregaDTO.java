package com.sptech.arquitetura.nuvem.data;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntregaDTO {

    private Long id;
    private String numeroRastreamento;
    private String status;
    private LocalDateTime dataPrevisaoEntrega;

}