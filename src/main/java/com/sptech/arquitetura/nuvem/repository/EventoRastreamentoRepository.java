package com.sptech.arquitetura.nuvem.repository;

import com.sptech.arquitetura.nuvem.entity.EventoRastreamento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EventoRastreamentoRepository  extends CrudRepository<EventoRastreamento, Long> {

    List<EventoRastreamento> findByEntregaIdOrderByDataEventoAsc(Long entregaId);

}
