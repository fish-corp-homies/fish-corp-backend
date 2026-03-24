package com.example.fish_corp_backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.util.List;

public record OceanForecastResponse(
        String type,
        Geometry geometry,
        Properties properties
) {
    public record Geometry(
            String type,
            List<Double> coordinates
    ) {}

    public record Properties(
            Meta meta,
            List<TimeSeries> timeseries
    ) {}

    public record Meta(
            @JsonProperty("updated_at") Instant updatedAt
            // You can add the 'units' object here if you actually need to read them,
            // but usually, it's safe to ignore them if you know the units in advance.
    ) {}

    public record TimeSeries(
            Instant time,
            Data data
    ) {}

    public record Data(
            InstantData instant
    ) {}

    // We name this InstantData to avoid clashing with java.time.Instant
    public record InstantData(
            Details details
    ) {}

    public record Details(
            @JsonProperty("sea_surface_wave_from_direction") Double seaSurfaceWaveFromDirection,
            @JsonProperty("sea_surface_wave_height") Double seaSurfaceWaveHeight,
            @JsonProperty("sea_water_speed") Double seaWaterSpeed,
            @JsonProperty("sea_water_temperature") Double seaWaterTemperature,
            @JsonProperty("sea_water_to_direction") Double seaWaterToDirection
    ) {}
}
