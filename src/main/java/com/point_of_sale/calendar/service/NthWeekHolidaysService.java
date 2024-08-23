package com.point_of_sale.calendar.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.point_of_sale.calendar.config.NthWeekHolidaysConfig;
import com.point_of_sale.calendar.model.Parsed3Tuple;

@Service
public class NthWeekHolidaysService implements IHolidayService {
    private final List<Parsed3Tuple> parsedDates;

    @Autowired
    public NthWeekHolidaysService(NthWeekHolidaysConfig config) {
        this.parsedDates = new ArrayList<>();
        for (String unparsedDate: config.getNthWeekOfMonth()) {
            String[] partitions = unparsedDate.split(",");
            Integer nthWeek = Integer.valueOf(partitions[0]);
            Integer weekday = Integer.valueOf(partitions[1]);
            
            // Month is 0 based, we adjust here to make the config human readable
            Integer month = Integer.valueOf(partitions[2]) - 1;
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

    @Override
    public List<LocalDate> getHolidays(Integer year) {
        List<LocalDate> dates = new ArrayList<>();
        for (Parsed3Tuple date: parsedDates) {
            dates.add(getDateFromNthWeekOfMonth(date, year));
        }
        return dates;
    } 


    
}
