package com.point_of_sale.calendar.config;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.joda.time.LocalDate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "holiday-config.base-holidays")
public class NthWeekHolidaysConfig {
    private List<String> nthWeekOfMonth;
    //Internal model to store parsed config. Cannot be converted to date immediately because year is parameterized and specified at checkout time
    private record Parsed3Tuple(Integer nthWeek, Integer weekday, Integer month) {}
    private List<Parsed3Tuple> parsedDates;

    NthWeekHolidaysConfig() {
        for (String unparsedDate: nthWeekOfMonth) {
            String[] partitions = unparsedDate.split(",");
            Integer nthWeek = Integer.valueOf(partitions[0]);
            Integer weekday = Integer.valueOf(partitions[1]);
            Integer month = Integer.valueOf(partitions[2]);
            parsedDates.add(new Parsed3Tuple(nthWeek, weekday, month));
        }
    }

    // in format "nth day, day of week (0 = Sunday 7 = Satuday), month"
    // i.e. "3,7,03" means The 3rd Saturday in March
    private LocalDate getDateFromNthWeekOfMonth(Parsed3Tuple nthWeekOfMonth, Integer year) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        calendar.set(Calendar.DAY_OF_WEEK, nthWeekOfMonth.weekday());
        calendar.set(Calendar.WEEK_OF_MONTH, nthWeekOfMonth.nthWeek());
        calendar.set(Calendar.MONTH, nthWeekOfMonth.month());
        calendar.set(Calendar.YEAR, year);
        LocalDate localDate = LocalDate.fromCalendarFields(calendar);
        return localDate;
    }

    public List<LocalDate> getNthWeekOfMonthHolidays(Integer year) {
        List<LocalDate> dates = List.of();
        for (Parsed3Tuple date: parsedDates) {
            dates.add(getDateFromNthWeekOfMonth(date, year));
        }
        return dates;
    } 

    public void setNthWeekOfMonth(List<String> nthDayOfMonth) {
        this.nthWeekOfMonth = nthDayOfMonth;
    }
    
}
