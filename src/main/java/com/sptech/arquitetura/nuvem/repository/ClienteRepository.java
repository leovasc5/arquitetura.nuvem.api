package com.sptech.arquitetura.nuvem.repository;

import com.sptech.arquitetura.nuvem.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    Optional<Cliente> findByNomeContaining(String nome);

}
