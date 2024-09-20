package com.stockup.StockUp.Model;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Grande")
public class Manager_Grande extends Manager{

    public Manager_Grande ( String nome, String cnpj, String email, String password) {
        super(nome, cnpj, email, password);
    }

    public Manager_Grande() {
    }

    @Override
    public String gerar_relatorios() {
        return "Relatorio Gerado";
    }

    @Override
    public String get_manager_type(){
        return "Grande";
    }

    @Override
    Produto cadastrar_produto(String descricao, String sku, Integer qtd_estoque, Categoria categoria, Float preco_unitario) {
        return new Produto(descricao,sku ,qtd_estoque , this ,categoria , preco_unitario);
    }
}
