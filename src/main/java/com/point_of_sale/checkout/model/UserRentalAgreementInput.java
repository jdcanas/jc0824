package com.point_of_sale.checkout.model;

import java.time.LocalDateTime;

import org.joda.time.LocalDate;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("user-input")
public record UserRentalAgreementInput(String toolCode, Integer rentalDayCount, Integer discountPercent, LocalDate checkoutDate) {
    public UserRentalAgreementInput {
        if (rentalDayCount < 1)  {
            throw new InvalidRentalAgreement("You must provide a number of days greater than 1 to rent this item.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new InvalidRentalAgreement("The discount must not exceed 100% and must not be negative.");
        }
    }
}