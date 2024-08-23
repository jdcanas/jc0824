package com.point_of_sale.calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.point_of_sale.calendar.config.NthWeekHolidaysConfig;

@SpringBootTest
public class NthWeekHolidaysConfigTest {
    @Autowired
    NthWeekHolidaysConfig config;

    @Test
    public void testHolidayConfigDate() {
        
    }
}
