package com.golearnit.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:properties/${environment}/database.properties")
public class GoLearnItPrimaryDbConfig {
}
