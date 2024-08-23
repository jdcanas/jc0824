package com.point_of_sale.cost.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.point_of_sale.cost.model.DiscountedPrice;
import com.point_of_sale.cost.service.CostService;

@SpringBootTest
public class CostServiceTest {
    @Autowired
    CostService costService;

    @Test
    public void testCost_Oneday() {
        BigDecimal originalPrice = new BigDecimal("1.49");
        BigDecimal cost = costService.getCost(originalPrice, 1);
        assertEquals(originalPrice, cost);
    }

    @Test
    public void testGetCharge_PaddingWithZeroes() {
        BigDecimal originalPrice = new BigDecimal("1.49");
        BigDecimal cost = costService.getCost(originalPrice, 10);
        assertEquals(new BigDecimal("14.90"), cost);
    }

    @Test
    public void testGetDiscount_RoundingUp() {
        BigDecimal originalPrice = new BigDecimal("1.49");
        DiscountedPrice discountObj = costService.applyDiscount(originalPrice, 30);

        assertEquals(new BigDecimal(".45"), discountObj.discountAmount());
        assertEquals(new BigDecimal("1.04"), discountObj.newPrice());
        assertEquals(30, discountObj.discountPercent());
        assertEquals(originalPrice, discountObj.originalPrice());
    }

    
    @Test
    public void testGetDiscount_RoundingDown() {
        BigDecimal originalPrice = new BigDecimal("1.49");
        DiscountedPrice discountObj = costService.applyDiscount(originalPrice, 29);

        assertEquals(new BigDecimal(".43"), discountObj.discountAmount());
        assertEquals(new BigDecimal("1.06"), discountObj.newPrice());
        assertEquals(29, discountObj.discountPercent());
        assertEquals(originalPrice, discountObj.originalPrice());
    }
    //33 percent discount 
}

