package com.point_of_sale.calendar.service;

import static org.joda.time.DateTimeConstants.SATURDAY;
import static org.joda.time.DateTimeConstants.SUNDAY;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.point_of_sale.calendar.config.ClosestWeekdayHolidaysConfig;
import com.point_of_sale.calendar.model.Parsed2Tuple;

@Service
public class ClosestWeekdayHolidaysService implements IHolidayService {
    private final List<Parsed2Tuple> parsedDates;

    @Autowired
    public ClosestWeekdayHolidaysService(ClosestWeekdayHolidaysConfig config) {
        parsedDates = new ArrayList<>();
        for (String dateString: config.getClosestWeekday()) {
            String[] partitions = dateString.split("-");
            // Month is 0 based, we adjust here to make the config human readable
            Integer month = Integer.valueOf(partitions[0]) - 1;
            Integer day = Integer.valueOf(partitions[1]);
            parsedDates.add(new Parsed2Tuple(month, day));
        }
    }

    private LocalDate getDateFromClosestWeekday(Parsed2Tuple parsedDate, Integer year) {
  
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        calendar.set(Calendar.DAY_OF_MONTH, parsedDate.day());
        calendar.set(Calendar.MONTH, parsedDate.month());
        calendar.set(Calendar.YEAR, year);
        LocalDate unadjustedDate = LocalDate.fromCalendarFields(calendar);
        // Adjust to nearest weekday
        if (unadjustedDate.getDayOfWeek() ==  SATURDAY) {
            return unadjustedDate.minusDays(1);
        } else if (unadjustedDate.getDayOfWeek() == SUNDAY) {
            return unadjustedDate.plusDays(1);
        } else {
            return unadjustedDate;
        }
    }

    @Override
    public List<LocalDate> getHolidays(Integer year) {
        List<LocalDate> dates = new ArrayList<>();
        for (Parsed2Tuple date: parsedDates) {
            dates.add(getDateFromClosestWeekday(date, year));
        }
        return dates;
    }
}
