package com.point_of_sale.calendar.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "holiday-config.base-holidays")
public class NthWeekHolidaysConfig {
    private List<String> nthWeekOfMonth;

    public void setNthWeekOfMonth(List<String> nthDayOfMonth) {
        this.nthWeekOfMonth = nthDayOfMonth;
    }

    public List<String> getNthWeekOfMonth() {
        return this.nthWeekOfMonth;
    }
    
}
