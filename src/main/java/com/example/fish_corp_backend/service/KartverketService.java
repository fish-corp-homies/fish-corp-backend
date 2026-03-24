package com.example.fish_corp_backend.service;

import com.example.fish_corp_backend.dto.TideForecastResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class KartverketService {
    private final RestClient restClient;

    public KartverketService(@Qualifier("kartverketClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public TideForecastResponse getTideForecast(String lat, String lon) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/vsl/tideforecast")
                        .queryParam("latitude", lat)
                        .queryParam("longitude", lon)
                        .queryParam("language", "nb")
                        .build())
                .retrieve()
                .body(TideForecastResponse.class);
    }
}
