package com.stockup.StockUp.Model;

public class Manager_Medio extends Manager{
    public Manager_Medio ( String nome, String cnpj, String email, String password) {
        super(nome, cnpj, email, password);
    }
    @Override
    public String gerar_relatorios() {
        return "Relatorio Medio Gerado";
    }
}
