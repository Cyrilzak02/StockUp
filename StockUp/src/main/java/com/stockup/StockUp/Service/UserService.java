package com.stockup.StockUp.Service;

import com.stockup.StockUp.Model.Manager;
import com.stockup.StockUp.repository.RepositoryManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

    @Service
    public class UserService {

        @Autowired
        private RepositoryManager repositoryManager;

        public Optional<Manager> getUserByEmailAndPassword(String email, String password) {
            return repositoryManager.findByEmailAndPassword(email, password);
        }
    }

