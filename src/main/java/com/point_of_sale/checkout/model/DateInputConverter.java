package com.point_of_sale.checkout.model;

import org.joda.time.LocalDate;
import org.springframework.core.convert.converter.Converter;

public class DateInputConverter implements Converter<String, LocalDate> {

    @Override
    //Expects a string of the format mm-dd-yyyy
    public LocalDate convert(String source) {
        String[] partitions = source.split("-");
        Integer year = Integer.valueOf(partitions[2]);
        Integer month = Integer.valueOf(partitions[0]);
        Integer day = Integer.valueOf(partitions[1]);
        LocalDate date = new LocalDate(year, month, day);
        return date;
    }
    
}
