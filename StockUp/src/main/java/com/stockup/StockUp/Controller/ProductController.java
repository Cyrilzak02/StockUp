package com.stockup.StockUp.Controller;

import com.stockup.StockUp.DTOs.ProdutoDTO;
import com.stockup.StockUp.DTOs.ProdutoVendaDTO;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private RepositoryProduto repositoryProduto;

    @Autowired
    private RepositoryCategoria repositoryCategoria;

    @Autowired
    private RepositoryManager repositoryManager;

    @Transactional
    @PostMapping("/criar_produto")
    public ResponseEntity<Produto> createProduct(@RequestBody ProdutoDTO produtoDTO) {
        try {
            logger.info("Creating product with SKU: {}", produtoDTO.getSku());

            Optional<Manager> managerOpt = repositoryManager.findById(produtoDTO.getManagerId());
            if (managerOpt.isEmpty()) {
                logger.warn("Manager with ID {} not found", produtoDTO.getManagerId());
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            Optional<Categoria> categoriaOpt = repositoryCategoria.findById(produtoDTO.getCategoriaId());
            if (categoriaOpt.isEmpty()) {
                logger.warn("Category with ID {} not found", produtoDTO.getCategoriaId());
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
            logger.info("Product with SKU {} created successfully", produtoDTO.getSku());

            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            logger.error("Error occurred while creating product", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    @GetMapping("/get_all_produto_infos")
    public ResponseEntity<List<ProdutoVendaDTO>> getAllProdutoInfos() {
        try {
            logger.info("Fetching all product info");

            List<ProdutoVendaDTO> produtos = repositoryProduto.findAllProdutoInfo();

            if (produtos.isEmpty()) {
                logger.info("No products found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            logger.info("Products retrieved successfully");
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error occurred while fetching product info", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
