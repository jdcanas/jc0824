package com.point_of_sale.checkout.model;

import org.joda.time.LocalDate;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("user-input")
public record UserRentalAgreementInput(String toolCode, Integer rentalDayCount, Integer discountPercent, String inputDate) {
    public UserRentalAgreementInput {
        if (rentalDayCount < 1)  {
            throw new InvalidRentalAgreement("You must provide a number of days greater than 1 to rent this item.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new InvalidRentalAgreement("The discount must not exceed 100% and must not be negative.");
        }
    }

       //Expects a string of the format mm-dd-yyyy
    public static LocalDate convert(String source) {
        String[] partitions = source.split("-");
        Integer year = Integer.valueOf(partitions[2]);
        Integer month = Integer.valueOf(partitions[0]);
        Integer day = Integer.valueOf(partitions[1]);
        LocalDate date = new LocalDate(year, month, day);
        return date;
    }

    public LocalDate checkoutDate() {
        return convert(inputDate);
    }
}