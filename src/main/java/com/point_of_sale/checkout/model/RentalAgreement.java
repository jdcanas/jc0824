package com.point_of_sale.checkout.model;

import com.point_of_sale.calendar.model.RentalDays;
import com.point_of_sale.cost.model.DiscountedPrice;

public class RentalAgreement {
    private final String toolCode;
    private final ITool tool;
    private final ToolMetadata metadata;
    private final RentalDays rentalDays;
    private final DiscountedPrice price;

    public RentalAgreement(String toolCode, ITool tool, ToolMetadata metadata, RentalDays rentalDays, DiscountedPrice price) {
        this.toolCode = toolCode;
        this.tool = tool;
        this.metadata = metadata;
        this.rentalDays = rentalDays;
        this.price = price;
    }

    public void printAgreement() {
        System.out.println("Tool code: " + toolCode);
        System.out.println("Tool type: " + tool.getType());
        System.out.println("Tool brand: " + metadata.brand());
        rentalDays.print();
        price.print();
    }
}
