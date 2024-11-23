package com.sptech.arquitetura.nuvem.service;

import com.sptech.arquitetura.nuvem.data.ClienteDTO;
import com.sptech.arquitetura.nuvem.data.EntregaDTO;
import com.sptech.arquitetura.nuvem.data.EntregaDetalhadaDTO;
import com.sptech.arquitetura.nuvem.entity.Cliente;
import com.sptech.arquitetura.nuvem.entity.Entrega;
import com.sptech.arquitetura.nuvem.repository.ClienteRepository;
import com.sptech.arquitetura.nuvem.repository.EntregaRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public List<EntregaDTO> listarTodasEntregas() {
        List<Entrega> entregas = entregaRepository.findAll();

        return entregas.stream()
                .map(this::toEntregaDTO)
                .collect(Collectors.toList());
    }

    public List<EntregaDTO> listarEntregasPorCliente(String nomeCliente) {
        List<Entrega> entregas = entregaRepository.findByClienteNomeContaining(nomeCliente);
        return entregas.stream().map(this::toEntregaDTO).toList();
    }

    public List<EntregaDTO> buscarEntregaPorNumeroRastreamento(String numeroRastreamento) {
        List<Entrega> entregas = entregaRepository.findByNumeroRastreamentoContaining(numeroRastreamento);

        return entregas.stream()
                .map(this::toEntregaDTO)
                .collect(Collectors.toList());
    }

    private EntregaDTO toEntregaDTO(Entrega entrega) {
        EntregaDTO dto = new EntregaDTO();
        dto.setId(entrega.getId());
        dto.setNumeroRastreamento(entrega.getNumeroRastreamento());
        dto.setStatus(entrega.getStatus());
        dto.setDataPrevisaoEntrega(entrega.getDataPrevisaoEntrega());
        return dto;
    }

    private EntregaDetalhadaDTO toEntregaDetalhadaDTO(Entrega entrega) {
        EntregaDetalhadaDTO dto = new EntregaDetalhadaDTO();
        dto.setId(entrega.getId());
        dto.setNumeroRastreamento(entrega.getNumeroRastreamento());
        dto.setEnderecoOrigem(entrega.getEnderecoOrigem());
        dto.setEnderecoDestino(entrega.getEnderecoDestino());
        dto.setDataPrevisaoEntrega(entrega.getDataPrevisaoEntrega());
        dto.setStatus(entrega.getStatus());

        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(entrega.getCliente().getId());
        clienteDTO.setNome(entrega.getCliente().getNome());
        clienteDTO.setEmail(entrega.getCliente().getEmail());
        dto.setCliente(clienteDTO);

        return dto;
    }
}
