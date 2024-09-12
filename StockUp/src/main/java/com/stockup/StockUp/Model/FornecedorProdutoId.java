package com.stockup.StockUp.Model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
public class FornecedorProdutoId implements Serializable {
    private Integer idProduto;
    private Integer idFornecedor;

    public FornecedorProdutoId() {
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FornecedorProdutoId that = (FornecedorProdutoId) o;
        return idProduto.equals(that.idProduto) && idFornecedor.equals(that.idFornecedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idFornecedor);
    }
}
