package com.point_of_sale.calendar.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "holiday-config.base-holidays")
public class ClosestWeekdayHolidaysConfig {
    private List<String> closestWeekday;
    
    public List<String> getClosestWeekday() {
        return closestWeekday;
    }

    public void setClosestWeekday(List<String> closestWeekday) {
        this.closestWeekday = closestWeekday;
    }
}
