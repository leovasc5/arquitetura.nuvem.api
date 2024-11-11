package com.sptech.arquitetura.nuvem.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntregaDetalhadaDTO {

    private Long id;
    private String numeroRastreamento;
    private ClienteDTO cliente;
    private String enderecoOrigem;
    private String enderecoDestino;
    private LocalDateTime dataPrevisaoEntrega;
    private String status;

}
