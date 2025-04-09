package com.unibave.projetoFarmacia.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unibave.projetoFarmacia.dto.ClienteAtualizacaoDTO;
import com.unibave.projetoFarmacia.model.Cliente;
import com.unibave.projetoFarmacia.services.ClienteService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll() {
        List<Cliente> clientes = service.listAll();
        if(clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente cliente = service.findById(id);
        if(cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("buscar/nome")
    public ResponseEntity<List<Cliente>> findByNome(@RequestParam String nome) {
        List<Cliente> clientes = service.findByNome(nome);
        if(clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("buscar/documento")
    public ResponseEntity<Cliente> findByDocumento(@RequestParam String documento) {
        Cliente cliente = service.findByDocumento(documento);
        if(cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("buscar/telefone")
    public ResponseEntity<Cliente> findByTelefone(@RequestParam String telefone) {
        Cliente cliente = service.findByTelefone(telefone);
        if(cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("buscar/email")
    public ResponseEntity<Cliente> findByEmail(@RequestParam String email) {
        Cliente cliente = service.findByEmail(email);
        if(cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@Valid @RequestBody Cliente cliente) {
        Cliente novoCliente = service.cadastrarCliente(cliente);
        return ResponseEntity.status(201).body(novoCliente);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Cliente> modificarCliente(@PathVariable Integer id, @RequestBody ClienteAtualizacaoDTO dto) {
        Cliente clienteModificado = service.modificarParcial(id, dto);
        return ResponseEntity.ok(clienteModificado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Integer id) {
        Cliente cliente = service.findById(id);
        if(cliente == null) {
            return ResponseEntity.notFound().build();
        }
        service.excluirCadastroCliente(cliente);
        return ResponseEntity.noContent().build();
    }
}
