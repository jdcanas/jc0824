package com.point_of_sale.calendar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClosestWeekdayHolidaysServiceTest {
    @Autowired
    ClosestWeekdayHolidaysService service;

    @Test
    public void testClosestDayHolidaySeryvice_baseCase() {
        List<LocalDate> dates = service.getHolidays(2024);


        LocalDate date = new LocalDate(2024, 7, 4);

        assertEquals(1, dates.size());
        assertTrue(dates.contains(date));
    }

    
    @Test
    public void testClosestDayHolidaySeryvice_4thIsOnSaturday() {
        List<LocalDate> dates = service.getHolidays(2020);


        LocalDate date = new LocalDate(2020, 7, 3);

        assertEquals(1, dates.size());
        System.out.println(dates.getFirst());
        assertTrue(dates.contains(date));
    }

    @Test
    public void testClosestDayHolidaySeryvice_4thIsOnSunday() {
        List<LocalDate> dates = service.getHolidays(2021);


        LocalDate date = new LocalDate(2021, 7, 5);

        assertEquals(1, dates.size());
        assertTrue(dates.contains(date));
    }
}

