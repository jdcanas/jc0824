package com.point_of_sale.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.point_of_sale.calendar.config.HolidayConfig;
import com.point_of_sale.checkout.dao.ToolDao;
import com.point_of_sale.checkout.model.Chainsaw;

@Controller
public class CheckoutController implements CommandLineRunner {

    @Autowired 
    ToolDao dao;
    @Autowired
    Chainsaw chainsaw;
    @Autowired
    HolidayConfig holidays;

    @Override
    public void run(String... args) {
        // this.printHello();
        // holidays.printStrings();
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
