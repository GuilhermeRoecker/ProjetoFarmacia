package com.unibave.projetoFarmacia.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.unibave.projetoFarmacia.dto.ClienteAtualizacaoDTO;
import com.unibave.projetoFarmacia.model.Cliente;
import com.unibave.projetoFarmacia.model.Endereco;
import com.unibave.projetoFarmacia.repository.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    //Insere repositorio no construtor
    //Injeção de dependência
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

    public Cliente modificarParcial(Integer id, ClienteAtualizacaoDTO dto) {
    Cliente cliente = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

    if (dto.getNome() != null) cliente.setNome(dto.getNome());
    if (dto.getEmail() != null) cliente.setEmail(dto.getEmail());
    if (dto.getTelefone() != null) cliente.setTelefone(dto.getTelefone());
    if (dto.getObservacoes() != null) cliente.setObservacoes(dto.getObservacoes());
    if (dto.getDtNascimento() != null) cliente.setDtNascimento(dto.getDtNascimento());
    if (dto.getPessoaTipo() != null) cliente.setPessoaTipo(dto.getPessoaTipo());

    if (dto.getEndereco() != null) {
        Endereco endereco = cliente.getEndereco();
        Endereco novoEndereco = dto.getEndereco();

        if (endereco == null) {
            endereco = new Endereco();
            cliente.setEndereco(endereco);
        }

        if (novoEndereco.getRua() != null) endereco.setRua(novoEndereco.getRua());
        if (novoEndereco.getNumero() != null) endereco.setNumero(novoEndereco.getNumero());
        if (novoEndereco.getBairro() != null) endereco.setBairro(novoEndereco.getBairro());
        if (novoEndereco.getCidade() != null) endereco.setCidade(novoEndereco.getCidade());
        if (novoEndereco.getEstado() != null) endereco.setEstado(novoEndereco.getEstado());
        if (novoEndereco.getCep() != null) endereco.setCep(novoEndereco.getCep());
    }

    return repository.save(cliente);
}


}

