package com.stockup.StockUp.Controller;


import com.stockup.StockUp.DTOs.LoginDTO;
import com.stockup.StockUp.DTOs.VendaDTO;
import com.stockup.StockUp.Model.Manager;
import com.stockup.StockUp.Model.Manager_Grande;
import com.stockup.StockUp.Model.Venda;
import com.stockup.StockUp.Service.UserService;
import com.stockup.StockUp.repository.MySqlRepository;
import com.stockup.StockUp.repository.RepositoryManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private RepositoryManager repositoryManager;
    @Autowired
    private UserService userService;

    @Transactional
    @GetMapping("/get_user")
    public ResponseEntity<Manager> createVenda(@RequestBody LoginDTO loginDTO) {




            String email = loginDTO.getEmail();
            String password = loginDTO.getPassword();

            // Call the service method to authenticate the user
            return userService.getUserByEmailAndPassword(email, password)
                    .map(user -> ResponseEntity.ok(user)) // Success, return user data
                    .orElseGet(() -> ResponseEntity.status(401)); // Failure, return error
        }





}
