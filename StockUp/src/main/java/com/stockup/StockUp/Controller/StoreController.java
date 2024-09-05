package com.stockup.StockUp.Controller;

import com.stockup.StockUp.Model.Manager;
import com.stockup.StockUp.repository.MySqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class StoreController {

    @Autowired
    MySqlRepository mySqlRepository;
    @GetMapping("/get-all-managers")
    public List<Manager> getManagers(){
         return mySqlRepository.findAll();
    }
    @GetMapping("/get-manager/{identity}")
    public Manager getManager(@PathVariable("identity") Integer id){
        return mySqlRepository.findById(id).get();

    }
    @DeleteMapping("/delete-manager/{identity}")
    public boolean deleteManager (@PathVariable("identity") Integer id){
        if(!mySqlRepository.findById(id).equals(Optional.empty())) {
            mySqlRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/update-manager/{id}") //for updating
    public Manager updateManagerName(@PathVariable("id") Integer id , @RequestBody Map<String,String> body){
        Manager current = mySqlRepository.findById(id).get();
        current.setNome(body.get("nome"));
        current.setEmail(body.get("email"));
        mySqlRepository.save(current);
        return current;


    }

    @PostMapping("/insert-manager")
    public Manager insertManager(@RequestBody Map<String , String> body){
        Manager current = new Manager(body.get("nome"), body.get("cnpj"),body.get("email"),body.get("senha"));
        mySqlRepository.save(current);
        return current;
    }



}
