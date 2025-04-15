package com.unibave.projetoFarmacia.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.unibave.projetoFarmacia.model.Fornecedor;
import com.unibave.projetoFarmacia.services.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService service;

    public FornecedorController(FornecedorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listAll() {
        List<Fornecedor> fornecedores = service.listAll();
        if (fornecedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Integer id) {
        Fornecedor fornecedor = service.findById(id);
        if (fornecedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedor);
    }

    @GetMapping("buscar/nome")
    public ResponseEntity<List<Fornecedor>> findByNome(@RequestParam String nome) {
        List<Fornecedor> fornecedores = service.findByNome(nome);
        if (fornecedores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(fornecedores);

    }

    @GetMapping("buscar/documento")
    public ResponseEntity<Fornecedor> findByDocumento(@RequestParam String documento) {
        Fornecedor fornecedor = service.findByDocumento(documento);
        if (fornecedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedor);
    }

    @GetMapping("buscar/telefone")
    public ResponseEntity<Fornecedor> findByTelefone(@RequestParam String telefone) {
        Fornecedor fornecedor = service.findByTelefone(telefone);
        if (fornecedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedor);
    }

    @GetMapping("buscar/email")
    public ResponseEntity<Fornecedor> findByEmail(@RequestParam String email) {
        Fornecedor fornecedor = service.findByEmail(email);
        if (fornecedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedor);
    }

    @GetMapping("buscar/razaoSocial")
    public ResponseEntity<Fornecedor> findByRazaoSocial(@RequestParam String razaoSocial) {
        Fornecedor fornecedor = service.findByRazaoSocial(razaoSocial);
        if (fornecedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedor);
    }

    @GetMapping("buscar/inscricaoEstadual")
    public ResponseEntity<Fornecedor> findByInscricaoEstadual(@RequestParam String inscricaoEstadual) {
        Fornecedor fornecedor = service.findByInscricaoEstadual(inscricaoEstadual);
        if (fornecedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedor);
    }

    @PostMapping
    public ResponseEntity<Fornecedor> cadastrarFornecedor(@RequestBody Fornecedor fornecedor) {
        Fornecedor novoFornecedor = service.cadastrarFornecedor(fornecedor);
        return ResponseEntity.status(201).body(novoFornecedor);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Fornecedor> modificarFornecedor(@PathVariable Integer id,
            @RequestBody Fornecedor fornecedor) {
        Fornecedor fornecedorAtualizado = service.modificarParcial(id, fornecedor);
        if (fornecedorAtualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornecedorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCadastroFornecedor(@PathVariable Integer id) {
        Fornecedor fornecedor = service.findById(id);
        if (fornecedor == null) {
            return ResponseEntity.notFound().build();
        }
        service.excluirCadastroFornecedor(fornecedor);
        return ResponseEntity.noContent().build();
    }

}
