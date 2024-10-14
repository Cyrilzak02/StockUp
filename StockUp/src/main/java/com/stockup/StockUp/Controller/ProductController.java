package com.stockup.StockUp.Controller;

import com.stockup.StockUp.DTOs.ProdutoDTO;
import com.stockup.StockUp.Model.Produto;
import com.stockup.StockUp.Model.Categoria;
import com.stockup.StockUp.Model.Manager;
import com.stockup.StockUp.repository.RepositoryProduto;
import com.stockup.StockUp.repository.RepositoryCategoria;
import com.stockup.StockUp.repository.RepositoryManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    @Autowired
    private RepositoryProduto repositoryProduto;

    @Autowired
    private RepositoryCategoria repositoryCategoria;

    @Autowired
    private RepositoryManager repositoryManager;

    @Transactional
    @PostMapping
    public ResponseEntity<Produto> createProduct(@RequestBody ProdutoDTO produtoDTO) {
        try {

            Optional<Manager> managerOpt = repositoryManager.findById(produtoDTO.getManagerId());
            if (managerOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }


            Optional<Categoria> categoriaOpt = repositoryCategoria.findById(produtoDTO.getCategoriaId());
            if (categoriaOpt.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Manager manager = managerOpt.get();
            Categoria categoria = categoriaOpt.get();

            Produto produto = manager.cadastrar_produto(
                    produtoDTO.getDescricao(),
                    produtoDTO.getSku(),
                    produtoDTO.getQtd_estoque(),
                    categoria,
                    produtoDTO.getPreco_unitario()
            );

            repositoryProduto.save(produto);

            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
