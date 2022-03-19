package com.javaminds.springbootiq.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("dev")
public class DevelopmentOnlyConfiguration {
    @Bean
    public String dummy(){
        return "DevelopmentOnlyConfiguration";
    }
}
