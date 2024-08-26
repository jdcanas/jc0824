package com.point_of_sale.cost.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.point_of_sale.cost.model.DiscountedPrice;

@Service
public class CostService {

    public DiscountedPrice getCostAndDiscount(BigDecimal costPerDay, Integer chargeDays, Integer discountPercent) {
        BigDecimal initialCost = getCost(costPerDay, chargeDays);
        DiscountedPrice price = applyDiscount(initialCost, discountPercent);
        return price;
    }

    public BigDecimal getCost(BigDecimal costPerDay, Integer chargeDays) {
        BigDecimal unroundedCharge = costPerDay.multiply(BigDecimal.valueOf(chargeDays));

        return unroundedCharge;
    }

    // Discount percent is assumed to be sanitized to an integer value between 0 and 100 before this point
    public DiscountedPrice applyDiscount(BigDecimal price, Integer discountPercent) {
        BigDecimal discountAmount = price.multiply(convertIntToFraction(discountPercent));
        BigDecimal roundedDiscount =  discountAmount.setScale(2, RoundingMode.HALF_EVEN);
        BigDecimal newPrice = price.subtract(roundedDiscount);
        return new DiscountedPrice(price, newPrice, roundedDiscount, discountPercent);
    }

    private BigDecimal convertIntToFraction(Integer discountPercent) {
        BigDecimal discountNumerator = BigDecimal.valueOf(discountPercent);
        BigDecimal hundred = new BigDecimal("100");
        return discountNumerator.divide(hundred, 2,  RoundingMode.HALF_UP);
    }
    
}
