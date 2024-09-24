package com.stockup.StockUp.repository;

import com.stockup.StockUp.Model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryFuncionario extends JpaRepository<Funcionario , Integer> {
}
