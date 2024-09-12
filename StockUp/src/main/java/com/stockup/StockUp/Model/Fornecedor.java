package com.stockup.StockUp.Model;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFornecedor;

    @Column(name = "razao_social")
    private String razao_social;

    public Fornecedor(String razao_social) {
        this.razao_social = razao_social;
    }
    @OneToMany(mappedBy = "fornecedores")
    private Set<FornecedorProduto> abastecimento = new HashSet<>();

    public Fornecedor() {
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }
}
