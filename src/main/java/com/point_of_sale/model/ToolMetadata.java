package com.point_of_sale.model;

public record ToolMetadata(ToolType type, String brand) { 
    @Override
    public String toString() {
        return "ToolMetaData(type= " + type + ", brand= " + brand + ")";
    }
}
