package com.golearnit.app.modules.quiz.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.golearnit")
//@EntityScan(basePackages = {"com.golearnit.data.module.quiz.entity"})
public class QuizModuleConfig {
}
