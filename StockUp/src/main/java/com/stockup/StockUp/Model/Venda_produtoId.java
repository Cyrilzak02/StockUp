package com.stockup.StockUp.Model;


import java.io.Serializable;
import java.util.Objects;

public class Venda_produtoId implements Serializable {

        private Integer idVenda;
        private Integer idProduto;


    public Venda_produtoId() {
    }

    public Integer getIdVenda() {
            return idVenda;
        }

        public void setIdVenda(Integer idVenda) {
            this.idVenda = idVenda;
        }

        public Integer getIdProduto() {
            return idProduto;
        }

        public void setIdProduto(Integer idProduto) {
            this.idProduto = idProduto;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Venda_produtoId that = (Venda_produtoId) o;
            return idProduto.equals(that.idProduto) && idVenda.equals(that.idVenda);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idProduto, idVenda);
        }
}
