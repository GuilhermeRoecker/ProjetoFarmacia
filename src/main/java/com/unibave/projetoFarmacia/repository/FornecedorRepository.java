package com.unibave.projetoFarmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibave.projetoFarmacia.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

    public List<Fornecedor> findByNome(String nome);
    public Fornecedor findByDocumento(String documento);
    public Fornecedor findByTelefone(String telefone);
    public Fornecedor findByEmail(String email);
    public Fornecedor findByRazaoSocial(String razaoSocial);
    public Fornecedor findByInscricaoEstadual(String inscricaoEstadual);

}
