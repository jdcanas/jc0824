package com.point_of_sale.calendar.service;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HolidayService {
    @Autowired
    private List<IHolidayService> baseHolidayServices;

    
    public List<LocalDate> getHolidays(Integer year) {
        List<LocalDate> dates = new ArrayList<>();
        for (IHolidayService holidayService: baseHolidayServices) {
            dates.addAll(holidayService.getHolidays(year));
        }
        return dates;
    } 

}
