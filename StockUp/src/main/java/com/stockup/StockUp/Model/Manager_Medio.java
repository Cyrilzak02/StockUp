package com.stockup.StockUp.Model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Medio")
public class Manager_Medio extends Manager{
    public Manager_Medio ( String nome, String cnpj, String email, String password) {
        super(nome, cnpj, email, password);
    }

    public Manager_Medio() {
    }

    @Override
    public String gerar_relatorios() {
        return "Relatorio Medio Gerado";
    }
    @Override
    public String get_manager_type(){
        return "Medio";
    }



    @Override
    public Produto cadastrar_produto(String descricao, String sku, Integer qtd_estoque, Categoria categoria, Float preco_unitario) {
        return new Produto(descricao,sku ,qtd_estoque , this ,categoria , preco_unitario);
    }

}
