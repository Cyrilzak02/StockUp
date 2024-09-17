package com.stockup.StockUp.Model;

public class SistemaInventarioFornecedor implements FornecedorObserver{
    @Override
    public void update(Fornecedor fornecedor){
        System.out.println("Inventory System: A new cargo of products has been registered. Updating inventory...");

        for (FornecedorProduto fornecedorProduto : fornecedor.getAbastecimento()){
            Produto produto = fornecedorProduto.getProduto();
            int quantidadeRecebida = fornecedorProduto.getQtd();

            int  novoEstoque = produto.getQtd_estoque() + quantidadeRecebida;
            produto.setQtd_estoque(novoEstoque);
        }

    }
}
