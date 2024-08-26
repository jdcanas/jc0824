package com.point_of_sale.checkout.model;

import org.springframework.stereotype.Component;

import com.point_of_sale.checkout.config.LadderToolConfig;

@Component
public class Ladder extends BaseTool {

    public Ladder(LadderToolConfig config) {
        this.config = config;
    }

    @Override
    public ToolType getType() {
        return ToolType.Ladder;
    }
    
}

