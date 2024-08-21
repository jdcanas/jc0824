package com.point_of_sale.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class CheckoutController implements CommandLineRunner {
    @Override
    public void run(String... args) {
        
    }

    public void printHello() {
        System.out.println("hello!");
    }
    
}
