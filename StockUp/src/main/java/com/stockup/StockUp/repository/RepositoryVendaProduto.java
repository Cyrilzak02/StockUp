package com.stockup.StockUp.repository;

import com.stockup.StockUp.Model.Venda_produto;
import com.stockup.StockUp.Model.Venda_produtoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryVendaProduto extends JpaRepository<Venda_produto , Venda_produtoId> {
}
