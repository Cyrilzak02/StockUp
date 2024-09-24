package com.stockup.StockUp.Model;
import jakarta.persistence.*;

import java.util.ArrayList;
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
    @OneToMany(mappedBy = "fornecedor")
    private ArrayList<FornecedorProduto> abastecimento;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor, String razao_social) {
        this.idFornecedor = idFornecedor;
        this.razao_social = razao_social;
        this.abastecimento = new ArrayList<>();
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

    public ArrayList<FornecedorProduto> getAbastecimento() {
        return abastecimento;
    }

    public void setAbastecimento(ArrayList<FornecedorProduto> abastecimento) {
        this.abastecimento = abastecimento;
    }


}
