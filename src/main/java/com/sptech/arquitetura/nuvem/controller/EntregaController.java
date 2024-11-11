package com.sptech.arquitetura.nuvem.controller;

import com.sptech.arquitetura.nuvem.data.EntregaDTO;
import com.sptech.arquitetura.nuvem.data.EntregaDetalhadaDTO;
import com.sptech.arquitetura.nuvem.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @GetMapping
    public ResponseEntity<List<EntregaDTO>> listarTodasEntregas() {
        List<EntregaDTO> entregas = entregaService.listarTodasEntregas();
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<EntregaDTO>> listarEntregasPorCliente(@PathVariable Long clienteId) {
        List<EntregaDTO> entregas = entregaService.listarEntregasPorCliente(clienteId);
        return ResponseEntity.ok(entregas);
    }

    @GetMapping("/{numeroRastreamento}")
    public ResponseEntity<EntregaDetalhadaDTO> buscarEntregaPorNumeroRastreamento(@PathVariable String numeroRastreamento) {
        EntregaDetalhadaDTO entrega = entregaService.buscarEntregaPorNumeroRastreamento(numeroRastreamento);
        return ResponseEntity.ok(entrega);
    }
}