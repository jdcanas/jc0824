package com.point_of_sale.calendar.config;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "holiday-config.base-holidays")
public class HolidayConfig {
    @Autowired
    private NthWeekHolidaysConfig nthWeekHolidaysConfig;
    @SuppressWarnings("unused")
    private List<String> closestWeekday;
    private List<String> staticHolidays;

    // public void printStrings() {
    //     ;
    //     for (String s: nthWeekHolidaysConfig.getNthWeekOfMonthHolidays(2024)) {
    //         System.out.println(s);
    //     }
    // }

    // public List<LocalDate> getHolidays(List<Integer> years) {
    //     List<Date> dates = List.of();
    //     for (Integer year: years) {
    //         dates.addAll(getNthWeekOfMonthHolidays(year));
    //         dates.addAll(geClosestWeekdayHolidays(year));
    //     }
    //     return dates;
    // }

   

    // public List<LocalDate> geClosestWeekdayHolidays(Integer year) {
    //     List<Date> dates = List.of();
    //     for (String date: nthWeekOfMonth) {
    //         dates.add(getDateFromNthWeekOfMonth(date, year));
    //     }
    //     return dates;
    // } 


    // private LocalDate getDateFromClosestWeekday(String closestWeekday, Integer year) {
    //     String[] partitions = closestWeekday.split("-");
        
    //     // Parse
    //     Integer month = Integer.valueOf(partitions[0]);
    //     Integer day = Integer.valueOf(partitions[1]);
    //     Calendar calendar = Calendar.getInstance();
    //     calendar.setTimeZone(TimeZone.getDefault());
    //     calendar.set(year, month, day);

    //     // Adjust to nearest weekday
    //     if (calendar.DAY_OF_WEEK == DayOfWeek.SATURDAY.getValue()) {
    //         calendar.set(year, month, day - 1);
    //     } else if (calendar.DAY_OF_WEEK == DayOfWeek.SUNDAY.getValue()) {
    //         calendar.set(year, month, day + 1);
    //     }

    //     Date date = calendar.getTime();
    //     return date;
    // }

 

    // public void setClosestWeekday(List<String> nthDayOfMonth) {
    //     this.closestWeekday = closestWeekday;
    // }
    
    
}