package com.stockup.StockUp.Model;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "venda_produto")
public class Venda_produto {

    @EmbeddedId
    private Venda_produtoId vendaProdutoId;

    @ManyToOne
    @MapsId("idVenda")
    @JoinColumn(name = "idvendas")
    private Venda venda;
    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "idprodutos")
    private Produto produto;

    @Column(name = "qtd_produto")
    private Integer qtd;

    public Venda_produtoId getVendaProdutoId() {
        return vendaProdutoId;
    }

    public void setVendaProdutoId(Venda_produtoId vendaProdutoId) {
        this.vendaProdutoId = vendaProdutoId;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQtd() {
        return qtd;
    }

    public void setQtd(Integer qtd) {
        this.qtd = qtd;
    }
}
