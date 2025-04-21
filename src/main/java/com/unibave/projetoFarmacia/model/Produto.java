package com.unibave.projetoFarmacia.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;
    @Column
    private String tipo;
    @Column
    private String fabricante;
    
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;

    @Column
    private String siteFornecedor;

    @Column
    private Date dataValidade;

    @Column
    private String prazoEntrega;

    @Column
    private Integer quantidadeEstoque;

    @Column
    private Integer quantidadeMinimaEstoque;

    @Column
    private Double precoCusto;

    @Column
    private Double precoVenda;

    @Column
    private String unidadeMedida;

    @Column
    private String descricao;


    public Produto() {
    }


    public Produto(Integer id, String nome, String tipo, String fabricante, Fornecedor fornecedor, String siteFornecedor, Date dataValidade, String prazoEntrega, Integer quantidadeEstoque, Integer quantidadeMinimaEstoque, Double precoCusto, Double precoVenda, String unidadeMedida, String descricao) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.fornecedor = fornecedor;
        this.siteFornecedor = siteFornecedor;
        this.dataValidade = dataValidade;
        this.prazoEntrega = prazoEntrega;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.unidadeMedida = unidadeMedida;
        this.descricao = descricao;
    }


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


    public String getTipo() {
        return tipo;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public String getFabricante() {
        return fabricante;
    }


    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }


    public Fornecedor getFornecedor() {
        return fornecedor;
    }


    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }


    public String getSiteFornecedor() {
        return siteFornecedor;
    }


    public void setSiteFornecedor(String siteFornecedor) {
        this.siteFornecedor = siteFornecedor;
    }


    public Date getDataValidade() {
        return dataValidade;
    }


    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }


    public String getPrazoEntrega() {
        return prazoEntrega;
    }


    public void setPrazoEntrega(String prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }


    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }


    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }


    public Integer getQuantidadeMinimaEstoque() {
        return quantidadeMinimaEstoque;
    }


    public void setQuantidadeMinimaEstoque(Integer quantidadeMinimaEstoque) {
        this.quantidadeMinimaEstoque = quantidadeMinimaEstoque;
    }


    public Double getPrecoCusto() {
        return precoCusto;
    }


    public void setPrecoCusto(Double precoCusto) {
        this.precoCusto = precoCusto;
    }


    public Double getPrecoVenda() {
        return precoVenda;
    }


    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }


    public String getUnidadeMedida() {
        return unidadeMedida;
    }


    public void setUnidadeMedida(String unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((fabricante == null) ? 0 : fabricante.hashCode());
        result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
        result = prime * result + ((siteFornecedor == null) ? 0 : siteFornecedor.hashCode());
        result = prime * result + ((dataValidade == null) ? 0 : dataValidade.hashCode());
        result = prime * result + ((prazoEntrega == null) ? 0 : prazoEntrega.hashCode());
        result = prime * result + ((quantidadeEstoque == null) ? 0 : quantidadeEstoque.hashCode());
        result = prime * result + ((quantidadeMinimaEstoque == null) ? 0 : quantidadeMinimaEstoque.hashCode());
        result = prime * result + ((precoCusto == null) ? 0 : precoCusto.hashCode());
        result = prime * result + ((precoVenda == null) ? 0 : precoVenda.hashCode());
        result = prime * result + ((unidadeMedida == null) ? 0 : unidadeMedida.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
        Produto other = (Produto) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (fabricante == null) {
            if (other.fabricante != null)
                return false;
        } else if (!fabricante.equals(other.fabricante))
            return false;
        if (fornecedor == null) {
            if (other.fornecedor != null)
                return false;
        } else if (!fornecedor.equals(other.fornecedor))
            return false;
        if (siteFornecedor == null) {
            if (other.siteFornecedor != null)
                return false;
        } else if (!siteFornecedor.equals(other.siteFornecedor))
            return false;
        if (dataValidade == null) {
            if (other.dataValidade != null)
                return false;
        } else if (!dataValidade.equals(other.dataValidade))
            return false;
        if (prazoEntrega == null) {
            if (other.prazoEntrega != null)
                return false;
        } else if (!prazoEntrega.equals(other.prazoEntrega))
            return false;
        if (quantidadeEstoque == null) {
            if (other.quantidadeEstoque != null)
                return false;
        } else if (!quantidadeEstoque.equals(other.quantidadeEstoque))
            return false;
        if (quantidadeMinimaEstoque == null) {
            if (other.quantidadeMinimaEstoque != null)
                return false;
        } else if (!quantidadeMinimaEstoque.equals(other.quantidadeMinimaEstoque))
            return false;
        if (precoCusto == null) {
            if (other.precoCusto != null)
                return false;
        } else if (!precoCusto.equals(other.precoCusto))
            return false;
        if (precoVenda == null) {
            if (other.precoVenda != null)
                return false;
        } else if (!precoVenda.equals(other.precoVenda))
            return false;
        if (unidadeMedida == null) {
            if (other.unidadeMedida != null)
                return false;
        } else if (!unidadeMedida.equals(other.unidadeMedida))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        return true;
    }

    

    
}
