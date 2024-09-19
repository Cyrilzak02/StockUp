package com.stockup.StockUp.Controller;

import com.stockup.StockUp.DTOs.ProdutoDTO;
import com.stockup.StockUp.DTOs.VendaDTO;
import com.stockup.StockUp.Model.Funcionario;
import com.stockup.StockUp.Model.Produto;
import com.stockup.StockUp.Model.Venda_produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.stockup.StockUp.repository.*;
import com.stockup.StockUp.Model.Venda;

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

    @PostMapping("/create")
    public ResponseEntity<Venda> createVenda(@RequestBody VendaDTO vendaDTO) {
        // Create a new Venda
        Venda venda = new Venda();
        venda.setValor(vendaDTO.getValor());
        venda.setData_venda(vendaDTO.getData_venda());

        // Fetch Funcionario from DB
        Funcionario funcionario = repositoryFuncionario.findById(vendaDTO.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionario not found"));
        venda.setFuncionario(funcionario);

        // Save Venda first to get the ID
        Venda savedVenda = repositoryVenda.save(venda);

        // Handle Venda_Produto (Product associations)
        for (ProdutoDTO produtoDTO : vendaDTO.getProdutos()) {
            Produto produto = repositoryProduto.findById(produtoDTO.getProdutoId())
                    .orElseThrow(() -> new RuntimeException("Produto not found"));

            Venda_produto vendaProduto = new Venda_produto();
            vendaProduto.setVenda(savedVenda);
            vendaProduto.setProduto(produto);
            vendaProduto.setQtd(produtoDTO.getQtd());

            repositoryVendaProduto.save(vendaProduto);
        }

        return ResponseEntity.ok(savedVenda);
    }
}
