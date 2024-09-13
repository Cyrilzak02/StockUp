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





}
