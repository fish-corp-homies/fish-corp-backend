package com.example.fish_corp_backend.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

public record TideForecast (
        List<Forecast> forecastList
) {
    public record Forecast(
            String status, //high

            Instant timestamp,
            Measurement measurement
    ) {}

    public record Measurement(
            Double value, //høyde i cm
            String unit //cm
    ) {}

}
