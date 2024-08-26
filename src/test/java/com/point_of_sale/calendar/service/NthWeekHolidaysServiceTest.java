package com.point_of_sale.calendar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NthWeekHolidaysServiceTest {
    @Autowired
    NthWeekHolidaysService service;

    @Test
    public void testNthWeekHolidaySeryvice_1year() {
        List<LocalDate> dates = service.getHolidays(2024);
        LocalDate date = new LocalDate(2024, 9, 2);

        assertEquals(1, dates.size());
        assertTrue(dates.contains(date));
    }
}

