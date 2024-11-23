package com.sptech.arquitetura.nuvem.repository;

import com.sptech.arquitetura.nuvem.entity.Entrega;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EntregaRepository extends CrudRepository<Entrega, Long> {

    List<Entrega> findByClienteNomeContaining(String nome);

    List<Entrega> findByNumeroRastreamentoContaining(String numeroRastreamento);

    List<Entrega> findByClienteId(Long id);

    List<Entrega> findAll();

}
