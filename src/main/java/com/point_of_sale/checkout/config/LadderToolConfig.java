package com.point_of_sale.checkout.config;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "sales.tools-config.ladder")
public record LadderToolConfig(BigDecimal dailyCharge, Boolean weekdayCharge, Boolean weekendCharge, Boolean holidayCharge) implements ToolConfig {}
