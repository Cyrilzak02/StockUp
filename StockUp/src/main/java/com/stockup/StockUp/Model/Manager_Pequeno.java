package com.stockup.StockUp.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Pequeno")
public class Manager_Pequeno extends Manager {
    public Manager_Pequeno ( String nome, String cnpj, String email, String password) {
        super(nome, cnpj, email, password);
    }

    public Manager_Pequeno() {
    }

    @Override
     public String gerar_relatorios(){
        return "Reletario Pequeno Gerado";
    }

    @Override
    public String get_manager_type(){
        return "Pequeno";
    }
    @Override
    public Produto cadastrar_produto(String descricao, String sku, Integer qtd_estoque, Categoria categoria, Float preco_unitario) {
        return new Produto(descricao,sku ,qtd_estoque , this ,categoria , preco_unitario);
    }
}
