package com.unibave.projetoFarmacia.dto;

import java.time.LocalDate;

import com.unibave.projetoFarmacia.enums.TipoPessoa;
import com.unibave.projetoFarmacia.model.Endereco;

public class ClienteAtualizacaoDTO {

    private String nome;
    private LocalDate dtNascimento;
    private String documento;
    private TipoPessoa pessoaTipo;
    private String telefone;
    private String email;
    private Endereco endereco;
    private String observacoes;

    // Getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoPessoa getPessoaTipo() {
        return pessoaTipo;
    }

    public void setPessoaTipo(TipoPessoa pessoaTipo) {
        this.pessoaTipo = pessoaTipo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
