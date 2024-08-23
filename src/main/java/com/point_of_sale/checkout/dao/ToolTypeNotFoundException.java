package com.point_of_sale.checkout.dao;

public class ToolTypeNotFoundException extends RuntimeException {
    ToolTypeNotFoundException() {
        super("Tried to get a tool whose type was not recognized. Ensure the app configuration is correct");
    }
}