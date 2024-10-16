package com.stockup.StockUp.repository;

import com.stockup.StockUp.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface RepositoryCategoria extends JpaRepository<Categoria, Integer> {

}