package com.stockup.StockUp.repository;

import com.stockup.StockUp.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategoria extends JpaRepository<Categoria, Integer> {

}