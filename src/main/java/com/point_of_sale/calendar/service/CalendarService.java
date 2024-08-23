package com.point_of_sale.calendar.service;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.point_of_sale.checkout.model.ITool;

@Service
public class CalendarService {
    // LocalDateTime holiday = LocalDateTime.of(year, month, dayOfMonth)();

    public LocalDateTime addDays(LocalDateTime day, Integer numDays) {
        return day.plusDays(numDays);
    }

    // public Integer getChargeableDays(ITool tool, Integer numDays) {
        
    // }

    // public Set<LocalDateTime> getHolidaysForYear(Integer year) {
        
    // }
    
}
