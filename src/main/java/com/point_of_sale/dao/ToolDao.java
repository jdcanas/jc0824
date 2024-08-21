package com.point_of_sale.dao;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.point_of_sale.model.ToolMetadata;

@Component
@ConfigurationProperties(prefix = "sales.tools")
public class ToolDao {
    private HashMap<String, ToolMetadata> metadata;

    public Map<String, ToolMetadata> getMetadata() {
        return metadata;
    }

    public void printTools() {
        for (ToolMetadata tool: metadata.values()) {
            System.out.println(tool);
        }
    }

    public void setMetadata(HashMap<String, ToolMetadata> metadata) {
        this.metadata = metadata;
    }
}