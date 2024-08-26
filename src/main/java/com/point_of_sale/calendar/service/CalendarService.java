package com.point_of_sale.calendar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.joda.time.DateTimeConstants.SATURDAY;
import static org.joda.time.DateTimeConstants.SUNDAY;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.point_of_sale.calendar.model.RentalDays;
import com.point_of_sale.checkout.model.ITool;

@Service
public class CalendarService {
    @Autowired
    private HolidayService holidayService;

    public RentalDays getChargeDays(LocalDate checkoutDate, Integer numDays, ITool tool) {
        // Calculate list of days between (checkout day + num days], exclusive of checkout day inclusive of final day
        List<LocalDate> remainingChargeDays = getAllDays(checkoutDate, numDays);

        if (!tool.getHolidayCharge()) {
            remainingChargeDays = filterHolidays(remainingChargeDays);
        }
        if (!tool.getWeekdayCharge()) {
            remainingChargeDays = remainingChargeDays.stream()
                .filter(day -> !isWeekday(day))
                .collect(Collectors.toList());
        }
        if (!tool.getWeekendCharge()) {
            remainingChargeDays = remainingChargeDays.stream()
                .filter(day -> !isWeekend(day))
                .collect(Collectors.toList());
        }

        RentalDays rentalDays = new RentalDays(remainingChargeDays.size(), numDays, checkoutDate);
        return rentalDays;
    }

    // Construct a list of all days from checkoutDay to numDays in future, inclusive of final day but not of checkout day
    public List<LocalDate> getAllDays(LocalDate checkoutDate, Integer numDays) {
        Integer daysRemaining = numDays;
        List<LocalDate> days = new ArrayList<>();
        LocalDate currentDay = checkoutDate;

        while (daysRemaining > 0) {
            //We do not include checkout day
            currentDay = currentDay.plusDays(1);
            days.add(currentDay);
            daysRemaining--;
        }
        return days;
    }

    public List<LocalDate> filterHolidays(List<LocalDate> days) {
        // Get all years in the range of checkout days
        Set<Integer> years = days.stream()
            .map(day -> day.getYear())
            .collect(Collectors.toSet());

        // map the years to the holidays in those years
        List<LocalDate> holidays = years.stream()
            .flatMap(year -> holidayService.getHolidays(year).stream())
            .collect(Collectors.toList());

        // Filter the days based on whether any of them are holidays
        List<LocalDate> filteredDays = days.stream()
            .filter(day -> !holidays.contains(day))
            .collect(Collectors.toList());

        return filteredDays;
    }

    public Boolean isWeekend(LocalDate day) {
        Boolean isWeekend = day.getDayOfWeek() == SUNDAY || day.getDayOfWeek() == SATURDAY;
        return isWeekend;
    }

    public Boolean isWeekday(LocalDate day) {
        return !isWeekend(day);
    }
}
