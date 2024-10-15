package com.stockup.StockUp.Controller;

import com.stockup.StockUp.DTOs.ProdutoDTO;
import com.stockup.StockUp.DTOs.VendaDTO;
import com.stockup.StockUp.Model.*;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.stockup.StockUp.repository.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private RepositoryVenda repositoryVenda;

    @Autowired
    private RepositoryProduto repositoryProduto;

    @Autowired
    private RepositoryVendaProduto repositoryVendaProduto;
    @Autowired
    private RepositoryFuncionario repositoryFuncionario;
    @Autowired
    private  SistemaInventario sistemaInventario;

    @CrossOrigin(origins = "http://localhost:3000")
    @Transactional
    @PostMapping("/create")
    public ResponseEntity<Venda> createVenda(@RequestBody VendaDTO vendaDTO) {
        // Create a new Venda
        Venda venda = new Venda();
        venda.setValor(vendaDTO.getValor());
        venda.setData_venda(vendaDTO.getData_venda());


        Funcionario funcionario = repositoryFuncionario.findById(vendaDTO.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionario not found"));
        venda.setFuncionario(funcionario);


        Venda savedVenda = repositoryVenda.save(venda);
        savedVenda.adicionarObserver(sistemaInventario);

        // Handle Venda_Produto (Product associations)
        for (ProdutoDTO produtoDTO : vendaDTO.getProdutos()) {


            Produto produto = repositoryProduto.findById(produtoDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto not found"));

            System.out.println("Before :"+produto.getQtd_estoque());


            Venda_produto vendaProduto = new Venda_produto();
            Venda_produtoId venda_produtoId = new Venda_produtoId();
            venda_produtoId.setIdProduto(produto.getIdProdutos());
            venda_produtoId.setIdVenda(venda.getIdVenda());
            vendaProduto.setVendaProdutoId(venda_produtoId);
            vendaProduto.setVenda(savedVenda);
            vendaProduto.setProduto(produto);
            vendaProduto.setQtd(produtoDTO.getQtd());
            venda.add_venda_produtos(vendaProduto);



            repositoryVendaProduto.save(vendaProduto);



        }
        repositoryVenda.save(venda);
        savedVenda.notificarObservers();


        return ResponseEntity.ok(savedVenda);
    }
}
