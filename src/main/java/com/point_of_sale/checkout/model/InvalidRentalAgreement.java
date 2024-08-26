package com.point_of_sale.checkout.model;

public class InvalidRentalAgreement extends IllegalArgumentException {
    InvalidRentalAgreement(String message) {
        super(message);
    }
}
