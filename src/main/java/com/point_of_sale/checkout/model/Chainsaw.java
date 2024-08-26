package com.point_of_sale.checkout.model;

import org.springframework.stereotype.Component;

import com.point_of_sale.checkout.config.ChainsawToolConfig;

@Component
public class Chainsaw extends BaseTool {

    public Chainsaw(ChainsawToolConfig config) {
        this.config = config;
    }

    @Override
    public ToolType getType() {
        return ToolType.ChainSaw;
    }
    
}
