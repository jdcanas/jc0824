package com.point_of_sale.checkout.model;

import java.math.BigDecimal;

import com.point_of_sale.checkout.config.ToolConfig;

public abstract class BaseTool implements ITool {

    public ToolConfig config;
 
    @Override
    public abstract ToolType getType();

    @Override
    public BigDecimal getDailyCharge() {
        return config.dailyCharge();
    }

    @Override
    public Boolean getWeekdayCharge() {
        return config.weekdayCharge();
    }

    @Override
    public Boolean getWeekendCharge() {
        return config.weekendCharge();
    }

    @Override
    public Boolean getHolidayCharge() {
        return config.holidayCharge();
    }

}
