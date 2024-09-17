package com.stockup.StockUp.Model;

public class Manager_Grande extends Manager{

    public Manager_Grande ( String nome, String cnpj, String email, String password) {
        super(nome, cnpj, email, password);
    }

    @Override
    public String gerar_relatorios() {
        return "Relatorio Gerado";
    }
}
