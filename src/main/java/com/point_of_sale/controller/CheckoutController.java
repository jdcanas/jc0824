package com.point_of_sale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.point_of_sale.dao.ToolDao;
import com.point_of_sale.model.Chainsaw;

@Controller
public class CheckoutController implements CommandLineRunner {

    @Autowired 
    ToolDao dao;
    @Autowired
    Chainsaw chainsaw;

    @Override
    public void run(String... args) {
        // this.printHello();
        this.printTools();
    }

    public void printHello() {
        System.out.println("hello!");
    }

    public void printChainsaw() {
        System.out.println(chainsaw.getType());
    }

    public void printTools() {
        dao.printTools();
    }


    
}
