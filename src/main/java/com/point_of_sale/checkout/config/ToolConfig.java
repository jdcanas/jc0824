package com.point_of_sale.checkout.config;

import java.math.BigDecimal;

public interface ToolConfig {
    BigDecimal dailyCharge();
    Boolean weekdayCharge();
    Boolean weekendCharge();
    Boolean holidayCharge();
}