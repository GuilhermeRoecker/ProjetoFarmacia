package com.unibave.projetoFarmacia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unibave.projetoFarmacia.model.Fornecedor;
import com.unibave.projetoFarmacia.model.Produto;
import com.unibave.projetoFarmacia.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }
    
    @PostMapping("/cadastrar")
    public String cadastrarProduto(Produto produto) {
        produtoService.cadastrarProduto(produto);
        return "Produto cadastrado com sucesso!";
    }

    @PatchMapping("/modificar")
    public String modificarProduto(Produto produto) {
        produtoService.modificarProduto(produto);
        return "Produto modificado com sucesso!";
    }

    @DeleteMapping("/excluir")
    public String excluirProduto(Produto produto) {
        produtoService.excluirCadastroProduto(produto);
        return "Produto excluído com sucesso!";
    }

    @GetMapping("/buscar/nome")
    public Produto buscarProdutoPorNome(String nome) {
        return produtoService.findByNome(nome);
    }

    @GetMapping("/buscar/tipo")
    public Produto buscarProdutoPorTipo(String tipo) {
        return produtoService.findByTipo(tipo);
    }

    @GetMapping("/buscar/fabricante")
    public Produto buscarProdutoPorFabricante(String fabricante) {
        return produtoService.findByFabricante(fabricante);
    }

    @GetMapping("/buscar/descricao")
    public Produto buscarProdutoPorDescricao(String descricao) {
        return produtoService.findByDescricao(descricao);
    }

    @GetMapping("/buscar/fornecedor")
    public Produto buscarProdutoPorFornecedor(Fornecedor fornecedor) {
        return produtoService.findByFornecedor(fornecedor);
    }

    @GetMapping("/listar")
    public List<Produto> listarProdutos() {
        return produtoService.listAll();
    }

    @GetMapping("/buscar/id")
    public Produto buscarProdutoPorId(Integer id) {
        return produtoService.findById(id);
    }
}
