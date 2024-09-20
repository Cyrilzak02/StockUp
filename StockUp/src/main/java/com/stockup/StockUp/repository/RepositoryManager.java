package com.stockup.StockUp.repository;

import com.stockup.StockUp.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryManager extends JpaRepository<Manager , Integer> {
}
