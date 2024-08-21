package com.point_of_sale.model;

import java.math.BigDecimal;

import com.point_of_sale.config.ToolConfig;

public abstract class BaseTool implements ITool {

    public ToolConfig toolConfig;

    @Override
    public abstract ToolType getType();

    @Override
    public String getBrand() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBrand'");
    }

    @Override
    public BigDecimal getDailyCharge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDailyCharge'");
    }

    @Override
    public Boolean getWeekdayCharge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWeekdayCharge'");
    }

    @Override
    public Boolean getWeekendCharge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getWeekendCharge'");
    }

    @Override
    public Boolean getHolidayCharge() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHolidayCharge'");
    }
    
}
