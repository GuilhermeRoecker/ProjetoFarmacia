package com.unibave.projetoFarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibave.projetoFarmacia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
