package com.point_of_sale.checkout.dao;

public class ToolCodeNotFoundException extends RuntimeException {
    ToolCodeNotFoundException() {
        super("Tried to get a tool whose code was not recognized. Ensure the app configuration is correct");
    }
}