package com.golearnit.data.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:properties/${environment}/database.properties")
@EntityScan(basePackages = {"com.golearnit.data.module.*.entity"})
public class GoLearnItPrimaryDbConfig {
}
