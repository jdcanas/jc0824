package com.point_of_sale.config;

import java.math.BigDecimal;

public interface ToolConfig {
    BigDecimal dailyCharge();
    Boolean weekdayCharge();
    Boolean weekendCharge();
    Boolean holidayCharge();
}