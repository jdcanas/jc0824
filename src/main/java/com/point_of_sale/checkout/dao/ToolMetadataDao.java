package com.point_of_sale.checkout.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.point_of_sale.checkout.model.ToolMetadata;

@Component
@ConfigurationProperties(prefix = "sales.tools")
public class ToolMetadataDao {
    private HashMap<String, ToolMetadata> metadata;

    public Map<String, ToolMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(HashMap<String, ToolMetadata> metadata) {
        this.metadata = metadata;
    }

    public ToolMetadata findMetadata(String toolCode) {
        if (metadata.containsKey(toolCode)) {
            return metadata.get(toolCode);
        } else {
            throw new ToolCodeNotFoundException();
        }
    }
}
