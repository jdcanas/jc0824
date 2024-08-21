package com.point_of_sale.config;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sales.tools-config.chainsaw")
public record ChainsawToolConfig(BigDecimal dailyCharge, Boolean weekdayCharge, Boolean weekendCharge, Boolean holidayCharge) implements ToolConfig {
}
