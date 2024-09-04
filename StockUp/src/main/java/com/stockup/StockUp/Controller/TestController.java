package com.stockup.StockUp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // @GetMapping lets us create the endpoints and what should be done for each endpoint
    @GetMapping("/")
    public String getHome(){
        return "Home;";
    }
    @GetMapping("/test")
    public String getTest(){
        return "Test";
    }
    @GetMapping("/person")
    public Person getPerson(){
        return  new Person("Cyril",10);
    }
}

class Person{


    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
