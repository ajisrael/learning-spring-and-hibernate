package com.github.ajisrael.springcoredemo.config;

import com.github.ajisrael.springcoredemo.common.Coach;
import com.github.ajisrael.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
