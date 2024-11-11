package com.sptech.arquitetura.nuvem.repository;

import com.sptech.arquitetura.nuvem.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
