package com.stockup.StockUp.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "manager")

public abstract class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmanager;

    @Column(name = "nome")
    private String nome;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "email")
    private String email;
    @Column(name = "senha")
    private String password;

    public Manager( String nome, String cnpj, String email, String password) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.password = password;
    }

    public Manager() {

    }

    public int getIdManager() {
        return idmanager;
    }

    public void setIdManager(int idManager) {
        this.idmanager = idManager;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    abstract String gerar_relatorios();
}
