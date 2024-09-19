package com.stockup.StockUp.Model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.sql.Date;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idvendas")
    private Integer idVenda;

    @OneToMany(mappedBy = "venda")
    private ArrayList<Venda_produto> venda_produtos;

    @Column(name = "valor_venda")
    private Float valor;

    @Column(name = "data_venda")
    private Date data_venda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idfuncionario")
    private Funcionario funcionario;


    public Venda() {
    }

    public Venda(Float valor, Date data_venda, Funcionario funcionario) {
        this.valor = valor;
        this.data_venda = data_venda;
        this.funcionario = funcionario;
        this.venda_produtos = new ArrayList<>();
    }
    @Transient
    private ArrayList<VendaObserver> observers;

    public void adicionarObserver(VendaObserver observer) {
        observers.add(observer);
    }

    public void removerObserver(VendaObserver observer) {
        observers.remove(observer);
    }

    public void notificarObservers() {
        for (VendaObserver observer : observers) {
            observer.update(this);
        }
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setVenda_produtos(ArrayList<Venda_produto> venda_produtos) {
        this.venda_produtos = venda_produtos;
    }

    public ArrayList<Venda_produto> getVenda_produtos() {
        return venda_produtos;
    }
}
