package com.point_of_sale.checkout.model;

import java.math.BigDecimal;

public interface ITool {
    ToolType getType();
    BigDecimal getDailyCharge();
    Boolean getWeekdayCharge();
    Boolean getWeekendCharge();
    Boolean getHolidayCharge();
}