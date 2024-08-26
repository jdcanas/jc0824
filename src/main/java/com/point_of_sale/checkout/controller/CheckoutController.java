package com.point_of_sale.checkout.controller;

import java.awt.im.InputContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.point_of_sale.calendar.model.RentalDays;
import com.point_of_sale.calendar.service.CalendarService;
import com.point_of_sale.checkout.dao.ToolDao;
import com.point_of_sale.checkout.dao.ToolMetadataDao;
import com.point_of_sale.checkout.model.Chainsaw;
import com.point_of_sale.checkout.model.ITool;
import com.point_of_sale.checkout.model.ToolMetadata;
import com.point_of_sale.checkout.model.UserRentalAgreementInput;
import com.point_of_sale.cost.model.DiscountedPrice;
import com.point_of_sale.cost.service.CostService;

@Controller
public class CheckoutController implements CommandLineRunner {

    @Autowired 
    ToolDao toolDao;
    @Autowired 
    ToolMetadataDao toolMetadataDao;
    @Autowired
    UserRentalAgreementInput userInput;
    @Autowired
    CalendarService calendarService;
    @Autowired
    CostService costService;

    @Override
    public void run(String... args) {
        ToolMetadata toolMetadata = toolMetadataDao.findMetadata(userInput.toolCode());
        ITool tool = toolDao.getTool(toolMetadata.type());

        RentalDays rentalDays = calendarService.getChargeDays(userInput.checkoutDate(), userInput.rentalDayCount(), tool);
        DiscountedPrice price = costService.getCostAndDiscount(tool.getDailyCharge(), rentalDays.chargeDays(), userInput.discountPercent());


        // this.printHello();
        // holidays.printStrings();
    }

    public void printHello() {
        System.out.println("hello!");
    }


    
}
