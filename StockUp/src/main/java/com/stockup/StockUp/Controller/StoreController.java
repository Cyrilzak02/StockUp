package com.stockup.StockUp.Controller;

import com.stockup.StockUp.Model.Manager;
import com.stockup.StockUp.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreController {

    @Autowired
    MySqlRepository mySqlRepository;
    @GetMapping("/get-all-managers")
    public List<Manager> getManagers(){
         return mySqlRepository.findAll();
    }



}
