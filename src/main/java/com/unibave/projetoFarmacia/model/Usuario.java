package com.unibave.projetoFarmacia.model;

import java.time.LocalDate;

import com.unibave.projetoFarmacia.enums.TipoPessoa;

import jakarta.persistence.Entity;

@Entity
public class Usuario extends Entidade {

    public Usuario(String nome, LocalDate dtNascimento, String documento, TipoPessoa pessoaTipo,
            String telefone, String email, Endereco endereco,
            String username, String senha, String role, String crm, String especialidade) {
        super(nome, dtNascimento, documento, pessoaTipo, telefone, email, endereco);
        this.username = username;
        this.senha = senha;
        this.role = role;
        this.crm = crm;
        this.especialidade = especialidade;
    }

    private String username;
    private String senha;
    private String role;
    private String crm;
    private String especialidade;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


    public String getCRM() {
        return this.crm;
    }

    public void setCRM(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((senha == null) ? 0 : senha.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((crm == null) ? 0 : crm.hashCode());
        result = prime * result + ((especialidade == null) ? 0 : especialidade.hashCode());
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
        Usuario other = (Usuario) obj;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        if (senha == null) {
            if (other.senha != null)
                return false;
        } else if (!senha.equals(other.senha))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (crm == null) {
            if (other.crm != null)
                return false;
        } else if (!crm.equals(other.crm))
            return false;
        if (especialidade == null) {
            if (other.especialidade != null)
                return false;
        } else if (!especialidade.equals(other.especialidade))
            return false;
        return true;
    }

    
}
