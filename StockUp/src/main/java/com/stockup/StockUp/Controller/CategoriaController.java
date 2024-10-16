package com.stockup.StockUp.Controller;


import com.stockup.StockUp.Model.Categoria;
import com.stockup.StockUp.repository.RepositoryCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {


    @Autowired
    private RepositoryCategoria repositoryCategoria;


    @GetMapping("/get_all_categoria")
    public ResponseEntity<List<Categoria>> get_Categorias() {
        try {
            List<Categoria> categorias = repositoryCategoria.findAll();
            return ResponseEntity.ok(categorias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
