package com.example.fish_corp_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientConfig {

    @Value("${api.metno.base-url}")
    private String metNoBaseUrl;

    @Bean(name = "metNoClient")
    public RestClient metNoClient(RestClient.Builder builder) {
        return builder
                .baseUrl(metNoBaseUrl)
                .defaultHeader("User-Agent", "FishCorpBackend/1.0 (joran@example.com)")
                .build();
    }
}