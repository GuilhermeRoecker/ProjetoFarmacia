package com.unibave.projetoFarmacia.model;


import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;


@Entity
public class Cliente extends Pessoa {

    private String observacoes;

    public Cliente(Integer id, String nome, LocalDate dtNascimento, String documento, TipoPessoa pessoaTipo,
            String telefone, String email, Endereco endereco, List<Pedido> pedidos, List<Prescricao> prescricoes) {
        super(id, nome, dtNascimento, documento, pessoaTipo, telefone, email, endereco, pedidos, prescricoes);
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((observacoes == null) ? 0 : observacoes.hashCode());
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
        Cliente other = (Cliente) obj;
        if (observacoes == null) {
            if (other.observacoes != null)
                return false;
        } else if (!observacoes.equals(other.observacoes))
            return false;
        return true;
    } 
}
