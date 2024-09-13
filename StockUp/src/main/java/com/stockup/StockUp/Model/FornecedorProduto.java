package com.stockup.StockUp.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.sql.Date;

@Entity
@Table(name = "fornecedor_produtos")
public class FornecedorProduto {
    @EmbeddedId
    private FornecedorProdutoId id;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name ="idProduto")
    private Produto produto;

    @ManyToOne
    @MapsId("idFornecedor")
    @JoinColumn(name ="idFornecedor")
    private Fornecedor fornecedor;

    @Column(name ="data_validade")
    private Date data_validade;

    @Column(name ="data_entrada")
    private Date data_entrada;

    @Column(name = "qtd")
    private Integer qtd;

    public FornecedorProduto() {
    }

    public FornecedorProduto(Produto produto, Fornecedor fornecedor, Date data_validade, Date data_entrada, Integer qtd) {
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.data_validade = data_validade;
        this.data_entrada = data_entrada;
        this.qtd = qtd;
    }

    public FornecedorProdutoId getId() {
        return id;
    }

    public void setId(FornecedorProdutoId id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getData_validade() {
        return data_validade;
    }

    public void setData_validade(Date data_validade) {
        this.data_validade = data_validade;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}
