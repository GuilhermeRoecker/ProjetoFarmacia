package com.unibave.projetoFarmacia.model;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    public Pessoa() {
    }

    public Pessoa(String nome, LocalDate dtNascimento, String documento, TipoPessoa pessoaTipo,
        String telefone, String email, Endereco endereco) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.documento = documento;
        this.pessoaTipo = pessoaTipo;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;
    
    @Column
    private LocalDate dtNascimento;

    @Column
    private String documento;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoPessoa pessoaTipo;

    @Column
    private String telefone;

    @Column
    private String email;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Prescricao> prescricoes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Prescricao> getPrescricoes() {
        return prescricoes;
    }

    public void setPrescricoes(List<Prescricao> prescricoes) {
        this.prescricoes = prescricoes;
    }
    
    
}
