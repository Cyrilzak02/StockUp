package com.stockup.StockUp.repository;

import com.stockup.StockUp.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProduto extends JpaRepository<Produto, Integer> {
}
