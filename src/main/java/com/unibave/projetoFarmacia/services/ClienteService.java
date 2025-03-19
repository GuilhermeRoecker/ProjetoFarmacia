package com.unibave.projetoFarmacia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unibave.projetoFarmacia.model.Cliente;
import com.unibave.projetoFarmacia.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrarCliente(Cliente c) {
        return repository.save(c);
    }

    public Cliente modificarCliente(Cliente c){
        return repository.save(c);
    }

    public Cliente findById(Integer id){
        return repository.findById(id).orElse(null);
    }

    public void excluirCadastroCliente(Cliente c){
        repository.delete(c);
    }

    public List<Cliente> listAll(){
        return repository.findAll();
    }

    public List<Cliente> findByNome(String nome){
        return repository.findByNome(nome);
    }

    public Cliente findByDocumento(String documento){
        return repository.findByDocumento(documento);
    }

    public Cliente findByTelefone(String telefone){
        return repository.findByTelefone(telefone);
    }

    public Cliente findByEmail(String email){
        return repository.findByEmail(email);
    }


}

