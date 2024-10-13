package com.stockup.StockUp.Controller;
import com.stockup.StockUp.DTOs.LoginDTO;
import com.stockup.StockUp.Model.Manager;
import com.stockup.StockUp.Service.UserService;
import com.stockup.StockUp.repository.RepositoryManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @Transactional
    @PostMapping("/authenticate_user")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginDTO loginDTO) {
        String email = loginDTO.getEmail();
        String password = loginDTO.getPassword();

        // Attempt to find the user with the provided email and password
        Optional<Manager> userOpt = userService.getUserByEmailAndPassword(email, password);


        if (userOpt.isPresent()) {
            Manager user = userOpt.get();
            return ResponseEntity.ok(user);  // Return 200 OK with user data
        }

        // If authentication fails, return a 401 Unauthorized status with a message
        return ResponseEntity.status(401).body("Invalid email or password");


    }
    }
