package com.stockup.StockUp.Model;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idprodutos")
    private Integer idProdutos;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "SKU")
    private String sku ;

    @Column(name = "qtd_estoque")
    private Integer qtd_estoque;

    @Column(name= "preco_unitario")
    private Float preco_unitario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idmanager")
    private Manager manager;

    @ManyToOne
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    @OneToMany(mappedBy = "produto")
    private List<FornecedorProduto> abastecimento;
    @OneToMany(mappedBy = "produto")
    private List<Venda_produto> venda_produtos;





    public Produto( String descricao, String sku, Integer qtd_estoque,Manager manager, Categoria categoria, Float preco_unitario) {
        this.descricao = descricao;
        this.sku = sku;
        this.qtd_estoque = qtd_estoque;
        this.categoria = categoria;
        this.manager = manager;
        this.abastecimento = new ArrayList<>();
        this.preco_unitario = preco_unitario;
    }

    public Produto() {
    }

    public void setIdProdutos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public Integer getIdProdutos() {
        return idProdutos;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(Integer qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public Manager getManager() {
        return manager;
    }



    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Float getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(Float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public List<FornecedorProduto> getAbastecimento() {
        return abastecimento;
    }

    public void setAbastecimento(ArrayList<FornecedorProduto> abastecimento) {
        this.abastecimento = abastecimento;
    }

    public List<Venda_produto> getVenda_produtos() {
        return venda_produtos;
    }

    public void setVenda_produtos(ArrayList<Venda_produto> venda_produtos) {
        this.venda_produtos = venda_produtos;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "idProdutos=" + idProdutos +
                ", descricao='" + descricao + '\'' +
                ", sku='" + sku + '\'' +
                ", qtd_estoque=" + qtd_estoque +
                ", preco_unitario=" + preco_unitario +
                ", manager=" + manager +
                ", categoria=" + categoria +
                ", abastecimento=" + abastecimento +
                ", venda_produtos=" + venda_produtos +
                '}';
    }
}
