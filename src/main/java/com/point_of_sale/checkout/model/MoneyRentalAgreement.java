package com.point_of_sale.checkout.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class MoneyRentalAgreement {
    @Min(value = 1)
    private final Integer numRentalDays;

    @Min(value = 0)
    @Max(value = 100)
    private final Integer discountPercent;

    private final LocalDateTime checkoutDate;

    public MoneyRentalAgreement(Integer numRentalDays, Integer discountPercent, LocalDateTime checkoutDate) throws InvalidRentalAgreement {
        this.numRentalDays = numRentalDays;
        this.discountPercent = discountPercent;
        this.checkoutDate = checkoutDate;
    }
    
    
    public Integer getChargeDays() {
        //TRANSFORM each day AFTER checkout through due date into a list of LocalDateTime
        //if its a weekend, filter if we need to
        //if its a weekday, filter if we need to
        //if its a holiday, filter if we need to
        return -1;
    }

    public Integer getPreDiscountCharge(Integer chargeDays) {
        return -1;
    }
 
}
