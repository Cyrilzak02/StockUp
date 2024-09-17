package com.stockup.StockUp.Model;

public class SistemaInventario implements VendaObserver{
    @Override
    public void update(Venda venda) {
        // Logic to update the inventory based on the sale
        System.out.println("Inventory System: A new sale has been registered. Updating inventory...");

        // Example: Deduct the product quantities from the inventory
        for (Venda_produto vendaProduto : venda.getVenda_produtos()) {
            Produto produto = vendaProduto.getProduto();
            int quantidadeVendida = vendaProduto.getQtd();

            // Update the product's stock
            int novoEstoque = produto.getQtd_estoque() - quantidadeVendida;
            produto.setQtd_estoque(novoEstoque);

            // Normally, you would save this updated product back to the database
            System.out.println("Updated stock for product: " + produto.getDescricao() + " New Stock: " + novoEstoque);
        }

        }

}
