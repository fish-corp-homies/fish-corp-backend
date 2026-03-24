package com.example.fish_corp_backend.model;

import lombok.Builder;

import java.time.Instant;

@Builder
public record WaterTempForecast(
        Instant timestamp,
        Double temperatureCelsius
) {}
