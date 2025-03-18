package com.unibave.projetoFarmacia.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Fornecedor extends Pessoa {

    private String razaoSocial;
    private String inscricaoEstadual;
    
    public Fornecedor(Integer id, String nome, LocalDate dtNascimento, String documento, TipoPessoa pessoaTipo,
            String telefone, String email, Endereco endereco, List<Pedido> pedidos, List<Prescricao> prescricoes,
            String razaoSocial, String inscricaoEstadual) {
        super(id, nome, dtNascimento, documento, pessoaTipo, telefone, email, endereco, pedidos, prescricoes);
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((razaoSocial == null) ? 0 : razaoSocial.hashCode());
        result = prime * result + ((inscricaoEstadual == null) ? 0 : inscricaoEstadual.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fornecedor other = (Fornecedor) obj;
        if (razaoSocial == null) {
            if (other.razaoSocial != null)
                return false;
        } else if (!razaoSocial.equals(other.razaoSocial))
            return false;
        if (inscricaoEstadual == null) {
            if (other.inscricaoEstadual != null)
                return false;
        } else if (!inscricaoEstadual.equals(other.inscricaoEstadual))
            return false;
        return true;
    }
}

