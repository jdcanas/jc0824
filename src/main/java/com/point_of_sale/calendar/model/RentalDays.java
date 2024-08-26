package com.point_of_sale.calendar.model;

import org.joda.time.LocalDate;

public record RentalDays(Integer chargeDays,  Integer rentalDays, LocalDate checkoutDate) {
    public void print() {
        System.out.println("Rental days: " + rentalDays);
        System.out.println("Checkout date: " + checkoutDate.toString());
        System.out.println("Due date: " + checkoutDate.plusDays(rentalDays).toString());
        System.out.println("Charge days: " + chargeDays);
    }
}
