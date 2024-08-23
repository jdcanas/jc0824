package com.point_of_sale.checkout.model;

import java.time.LocalDateTime;

//TODO: config
public record UserRentalAgreementInput(String toolCode, Integer numRentalDays, Integer discountPercent, LocalDateTime checkoutDate) {
    public UserRentalAgreementInput {
        if (numRentalDays < 1)  {
            throw new InvalidRentalAgreement("You must provide a number of days greater than 1 to rent this item.");
        }
        if (discountPercent < 0 || discountPercent > 100) {
            throw new InvalidRentalAgreement("The discount must not exceed 100% and must not be negative.");
        }
    }
}