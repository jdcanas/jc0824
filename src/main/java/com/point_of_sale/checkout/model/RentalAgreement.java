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

    public void print() {
        System.out.println("\n\n");
        System.out.println("==== Rental Agreement ====");
        System.out.println("Tool code: " + toolCode);
        System.out.println("Tool type: " + tool.getType());
        System.out.println("Tool brand: " + metadata.brand());
        rentalDays.print();
        price.print();
        System.out.println("== End Rental Agreement ==");
        System.out.println("\n\n");
    }

    public String getToolCode() {
        return toolCode;
    }

    public ITool getTool() {
        return tool;
    }

    public ToolMetadata getMetadata() {
        return metadata;
    }

    public RentalDays getRentalDays() {
        return rentalDays;
    }

    public DiscountedPrice getPrice() {
        return price;
    }
}
