package com.unibave.projetoFarmacia.model;

import java.time.LocalDate;

import com.unibave.projetoFarmacia.enums.Sexo;
import com.unibave.projetoFarmacia.enums.TipoPessoa;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Cliente extends Entidade {

    private String observacoes;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Cliente() {
    }

    public Cliente(String nome, LocalDate dtNascimento, String documento, TipoPessoa pessoaTipo,
                   String telefone, String email, Endereco endereco, Sexo sexo, String observacoes) {
        super(nome, dtNascimento, documento, pessoaTipo, telefone, email, endereco);
        this.sexo = sexo;
        this.observacoes = observacoes;
    }

    public Cliente(String nome, LocalDate dtNascimento, String documento, TipoPessoa pessoaTipo,
                   String telefone, String email, Endereco endereco, Sexo sexo) {
        super(nome, dtNascimento, documento, pessoaTipo, telefone, email, endereco);
        this.sexo = sexo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
        result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!super.equals(obj)) return false;
        if (getClass() != obj.getClass()) return false;
        
        Cliente other = (Cliente) obj;
        
        return ((observacoes == null && other.observacoes == null) || 
                (observacoes != null && observacoes.equals(other.observacoes)))
                && sexo == other.sexo;
    }
    
}
