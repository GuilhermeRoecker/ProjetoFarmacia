package com.unibave.projetoFarmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unibave.projetoFarmacia.model.Fornecedor;
import com.unibave.projetoFarmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    public Produto findByNome(String nome);
    public Produto findByTipo(String tipo);
    public Produto findByFabricante(String fabricante);
    public Produto findByDescricao(String descricao);
    public Produto findByFornecedor(Fornecedor fornecedor);
}
