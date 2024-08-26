package com.point_of_sale.calendar.service;

import java.util.List;

import org.joda.time.LocalDate;

public interface IHolidayService {
    public List<LocalDate> getHolidays(Integer year);
}
