package com.stockup.StockUp.Model;

public class Manager_Pequeno extends Manager {
    public Manager_Pequeno ( String nome, String cnpj, String email, String password) {
        super(nome, cnpj, email, password);
    }

    @Override
     public String gerar_relatorios(){
        return "Reletario Pequeno Gerado";
    }
}
