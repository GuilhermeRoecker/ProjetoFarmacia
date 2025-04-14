package com.unibave.projetoFarmacia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unibave.projetoFarmacia.model.Fornecedor;
import com.unibave.projetoFarmacia.repository.FornecedorRepository;

@Service
public class FornecedorService {

    private final FornecedorRepository repository;

    public FornecedorService(FornecedorRepository repository) {
        this.repository = repository;
    }

    public Fornecedor cadastrarFornecedor(Fornecedor f) {
        return repository.save(f);
    }

    public Fornecedor modificarFornecedor(Fornecedor f) {
        return repository.save(f);
    }

    public Fornecedor findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public void excluirCadastroFornecedor(Fornecedor f) {
        repository.delete(f);
    }

    public List<Fornecedor> listAll() {
        return repository.findAll();
    }

    public List<Fornecedor> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public Fornecedor findByDocumento(String documento) {
        return repository.findByDocumento(documento);
    }

    public Fornecedor findByTelefone(String telefone) {
        return repository.findByTelefone(telefone);
    }

    public Fornecedor findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Fornecedor findByRazaoSocial(String razaoSocial) {
        return repository.findByRazaoSocial(razaoSocial);
    }

    public Fornecedor findByInscricaoEstadual(String inscricaoEstadual) {
        return repository.findByInscricaoEstadual(inscricaoEstadual);
    }

    public Fornecedor modificarParcial(Integer id, Fornecedor fornecedor) {
        Fornecedor f = repository.findById(id).orElse(null);
        if (f != null) {
            f.setNome(fornecedor.getNome());
            f.setDocumento(fornecedor.getDocumento());
            f.setTelefone(fornecedor.getTelefone());
            f.setEmail(fornecedor.getEmail());
            f.setRazaoSocial(fornecedor.getRazaoSocial());
            f.setInscricaoEstadual(fornecedor.getInscricaoEstadual());
            return repository.save(f);
        }
        return null;
    }

    
    

}
