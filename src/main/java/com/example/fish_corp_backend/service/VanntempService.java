package com.example.fish_corp_backend.service;

import com.example.fish_corp_backend.dto.OceanForecastResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class VanntempService {

    private final RestClient restClient;

    public VanntempService(@Qualifier("metNoClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public OceanForecastResponse getOceanForecast(String lat, String lon) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/weatherapi/oceanforecast/2.0/complete")
                        .queryParam("lat", lat)
                        .queryParam("lon", lon)
                        .build())
                .retrieve()
                .body(OceanForecastResponse.class);
    }
}
