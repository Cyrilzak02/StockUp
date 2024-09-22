package com.stockup.StockUp.Model;

import com.stockup.StockUp.repository.RepositoryProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SistemaInventario implements VendaObserver{
    @Autowired
    private RepositoryProduto repositoryProduto;
    @Override
    public void update(Venda venda) {
        // Logic to update the inventory based on the sale
        System.out.println("Inventory System: A new sale has been registered. Updating inventory...");

        if(venda.getVenda_produtos().isEmpty()){
            System.out.println("We're fucked");
        }
        for (Venda_produto vendaProduto : venda.getVenda_produtos()) {
            Produto produto = vendaProduto.getProduto();
            int quantidadeVendida = vendaProduto.getQtd();

            // Update the product's stock
            int novoEstoque = produto.getQtd_estoque() - quantidadeVendida;
            produto.setQtd_estoque(novoEstoque);
            repositoryProduto.save(produto);

            // Normally, you would save this updated product back to the database
            System.out.println("Updated stock for product: " + produto.getDescricao() + " New Stock: " + novoEstoque);

        }

        }

}
