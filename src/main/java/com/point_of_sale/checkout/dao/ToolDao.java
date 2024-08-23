package com.point_of_sale.checkout.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.point_of_sale.checkout.model.ITool;
import com.point_of_sale.checkout.model.ToolType;

@Component
@ConfigurationProperties(prefix = "sales.tools")
public class ToolDao {
    @Autowired
    private List<ITool> tools;

    public void printTools() {
        for (ITool tool: tools) {
            System.out.println(tool);
        }
    }

    public ITool getTool(ToolType type) {
        return tools.stream()
            .filter(tool -> tool.getType().equals(type))
            .findFirst()
            .orElseThrow(() -> new ToolTypeNotFoundException());
    }

}