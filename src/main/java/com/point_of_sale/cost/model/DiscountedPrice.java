package com.point_of_sale.cost.model;

import java.math.BigDecimal;

public record DiscountedPrice(BigDecimal originalPrice, BigDecimal finalPrice, BigDecimal discountAmount, Integer discountPercent) {
    public void print() {
        System.out.println("Pre-discount charge: " + originalPrice);
        System.out.println("Discount percent: " + discountPercent);
        System.out.println("Discount amount: " + discountAmount);
        System.out.println("Final Charge: " + finalPrice);
    }
}
