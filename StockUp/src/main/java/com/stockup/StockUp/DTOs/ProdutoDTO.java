package com.stockup.StockUp.DTOs;

public class ProdutoDTO {
    private Integer produtoId;
    private Integer qtd;

    private String descricao;
    private String sku;
    private Integer qtd_estoque;
    private Float preco_unitario;
    private Integer managerId;
    private final Integer categoriaId;


    public ProdutoDTO(Integer produtoId, Integer qtd, String descricao, String sku,
                      Integer qtd_estoque, Float preco_unitario, Integer managerId,
                      String managerType, Integer categoriaId) {
        this.produtoId = produtoId;
        this.qtd = qtd;
        this.descricao = descricao;
        this.sku = sku;
        this.qtd_estoque = qtd_estoque;
        this.preco_unitario = preco_unitario;
        this.managerId = managerId;
        this.categoriaId = categoriaId;
    }

    // Getters e Setters

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSku() {
        return sku;
    }

    public Integer getQtd_estoque() {
        return qtd_estoque;
    }

    public Float getPreco_unitario() {
        return preco_unitario;
    }


    public Integer getManagerId() {
        return managerId;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }
}
