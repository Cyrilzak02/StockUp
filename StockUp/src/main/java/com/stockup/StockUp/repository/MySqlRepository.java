package com.stockup.StockUp.repository;

import com.stockup.StockUp.Model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<Manager , Integer> {

}
