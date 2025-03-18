package com.unibave.projetoFarmacia.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Prescricao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Pessoa cliente;

    private String nomeArquivo;

    private String caminhoArquivo;

    private LocalDate dataAnexo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public LocalDate getDataAnexo() {
        return dataAnexo;
    }

    public void setDataAnexo(LocalDate dataAnexo) {
        this.dataAnexo = dataAnexo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((nomeArquivo == null) ? 0 : nomeArquivo.hashCode());
        result = prime * result + ((caminhoArquivo == null) ? 0 : caminhoArquivo.hashCode());
        result = prime * result + ((dataAnexo == null) ? 0 : dataAnexo.hashCode());
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
        Prescricao other = (Prescricao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (nomeArquivo == null) {
            if (other.nomeArquivo != null)
                return false;
        } else if (!nomeArquivo.equals(other.nomeArquivo))
            return false;
        if (caminhoArquivo == null) {
            if (other.caminhoArquivo != null)
                return false;
        } else if (!caminhoArquivo.equals(other.caminhoArquivo))
            return false;
        if (dataAnexo == null) {
            if (other.dataAnexo != null)
                return false;
        } else if (!dataAnexo.equals(other.dataAnexo))
            return false;
        return true;
    }

}

