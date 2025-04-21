package com.unibave.projetoFarmacia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unibave.projetoFarmacia.model.Fornecedor;
import com.unibave.projetoFarmacia.model.Produto;
import com.unibave.projetoFarmacia.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarProduto(Produto p) {
        repository.save(p);
    }

    public void modificarProduto(Produto p) {
        repository.save(p);
    }

    public Produto findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void excluirCadastroProduto(Produto p) {
        repository.delete(p);
    }

    public List<Produto> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public Produto findByTipo(String tipo) {
        return repository.findByTipo(tipo);
    }

    public Produto findByFabricante(String fabricante) {
        return repository.findByFabricante(fabricante);
    }

    public Produto findByDescricao(String descricao) {
        return repository.findByDescricao(descricao);
    }

    public Produto findByFornecedor(Fornecedor fornecedor) {
        return repository.findByFornecedor(fornecedor);
    }

    public List<Produto> listAll() {
        return repository.findAll();
    }

}
