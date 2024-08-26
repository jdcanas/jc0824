package com.point_of_sale.checkout.model;

import org.springframework.stereotype.Component;

import com.point_of_sale.checkout.config.JackhammerToolConfig;

@Component
public class Jackhammer extends BaseTool {

    public Jackhammer(JackhammerToolConfig config) {
        this.config = config;
    }

    @Override
    public ToolType getType() {
        return ToolType.Jackhammer;
    }
    
}
