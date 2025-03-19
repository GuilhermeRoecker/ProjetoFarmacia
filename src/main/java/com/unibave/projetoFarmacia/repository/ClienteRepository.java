package com.unibave.projetoFarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibave.projetoFarmacia.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    public List<Cliente> findByNome(String nome);
    public Cliente findByDocumento(String documento);
    public Cliente findByTelefone(String telefone);
    public Cliente findByEmail(String email);
}
