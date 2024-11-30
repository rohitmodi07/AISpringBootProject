package com.vlambo3.IASpringBootProject.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class ConfigurationAI {

    @Value("${apiKey}")
    private String apiKey;
    @Value("${sentiment_url}")
    private String sentimentUrl;

    @Value("${textToImage_url}")
    private String textToImageUrl;

    @Bean
    public String sentimentUrl() {
        return this.sentimentUrl;
    }

    @Bean
    public String textToImageUrl() {
        return this.textToImageUrl;
    }
    @Bean
    public String apiKey() {
        return this.apiKey;
    }
}
