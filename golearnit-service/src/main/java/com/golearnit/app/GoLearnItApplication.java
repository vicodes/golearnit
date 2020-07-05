package com.golearnit.app;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class GoLearnItApplication {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = new SpringApplicationBuilder(GoLearnItApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .properties("spring.config.name:properties/${environment}/application")
                .build()
                .run(args);

    }

}