package com.unibave.projetoFarmacia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping
    public List<Produto> listAll() {
        return produtoService.listAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto produto = produtoService.findById(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @GetMapping("buscar/nome")
    public ResponseEntity<List<Produto>> findByNome(@RequestParam String nome) {
        List<Produto> produtos = produtoService.findByNome(nome);
        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produtos);
    }
    
    @GetMapping("buscar/tipo")
    public ResponseEntity<Produto> findByTipo(@RequestParam String tipo) {
        Produto produto = produtoService.findByTipo(tipo);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @GetMapping("buscar/fabricante")
    public ResponseEntity<Produto> findByFabricante(@RequestParam String fabricante) {
        Produto produto = produtoService.findByFabricante(fabricante);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @GetMapping("buscar/descricao")
    public ResponseEntity<Produto> findByDescricao(@RequestParam String descricao) {
        Produto produto = produtoService.findByDescricao(descricao);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @GetMapping("buscar/fornecedor")
    public ResponseEntity<Produto> findByFornecedor(@RequestParam Fornecedor fornecedor) {
        Produto produto = produtoService.findByFornecedor(fornecedor);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok(produto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Produto> modificarProduto(@PathVariable Integer id, @RequestBody Produto produto) {
        Produto existingProduto = produtoService.findById(id);
        if (existingProduto == null) {
            return ResponseEntity.notFound().build();
        }
        produto.setId(id); // Ensure the ID is set correctly
        produtoService.modificarProduto(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCadastroProduto(@PathVariable Integer id) {
        Produto produto = produtoService.findById(id);
        if (produto == null) {
            return ResponseEntity.notFound().build();
        }
        produtoService.excluirCadastroProduto(produto);
        return ResponseEntity.noContent().build();
    }
}
