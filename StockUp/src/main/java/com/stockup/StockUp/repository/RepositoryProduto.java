package com.stockup.StockUp.repository;

import com.stockup.StockUp.DTOs.ProdutoVendaDTO;
import com.stockup.StockUp.Model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryProduto extends JpaRepository<Produto, Integer> {
    @Query("SELECT new com.stockup.StockUp.DTOs.ProdutoVendaDTO(p.idProdutos, p.descricao, p.preco_unitario) FROM Produto p")
    List<ProdutoVendaDTO> findAllProdutoInfo();
}
