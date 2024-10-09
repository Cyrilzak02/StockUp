package com.stockup.StockUp.repository;

import com.stockup.StockUp.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryManager extends JpaRepository<Manager , Integer> {
    Optional<Manager> findByEmailAndPassword(String email, String password);
}
