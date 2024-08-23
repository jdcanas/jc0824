package com.point_of_sale.cost.model;

import java.math.BigDecimal;

public record DiscountedPrice(BigDecimal originalPrice, BigDecimal newPrice, BigDecimal discountAmount, Integer discountPercent) {}
