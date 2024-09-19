package com.stockup.StockUp.Model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import com.stockup.StockUp.Model.SistemaInventario;
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idfuncionario")
    private  Integer idFuncionario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String email, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Venda cadastrar_venda(Float valor, Date data_venda, Funcionario funcionario , ArrayList<Venda_produto> Venda_produtos) {
        Venda venda = new Venda(valor , data_venda , funcionario);
        venda.setVenda_produtos(Venda_produtos);
        venda.notificarObservers();


        return venda;
    }









}
