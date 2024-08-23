package com.point_of_sale.checkout.model;

import java.time.LocalDateTime;

public class ToolRentalAgreement {
    private ITool tool;
    private ToolMetadata metadata;
    private String toolCode;

     public ToolRentalAgreement(ToolMetadata metadata, ITool tool, String toolCode) {
        this.metadata = metadata;
        this.tool = tool;
        this.toolCode = toolCode;
    }

    
}
