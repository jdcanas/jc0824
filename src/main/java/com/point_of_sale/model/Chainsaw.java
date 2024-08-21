package com.point_of_sale.model;

import org.springframework.stereotype.Component;

import com.point_of_sale.config.ChainsawToolConfig;

@Component
public class Chainsaw extends BaseTool {

    public Chainsaw(ChainsawToolConfig config) {
        this.toolConfig = config;
    }

    @Override
    public ToolType getType() {
        return ToolType.ChainSaw;
    }
    
}
