package com.point_of_sale.model;

import java.math.BigDecimal;



public interface ITool {
    ToolType getType();
    String getBrand();
    BigDecimal getDailyCharge();
    Boolean getWeekdayCharge();
    Boolean getWeekendCharge();
    Boolean getHolidayCharge();
}