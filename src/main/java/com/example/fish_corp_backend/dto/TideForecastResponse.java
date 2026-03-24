package com.example.fish_corp_backend.dto;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

public record TideForecastResponse(
        QueryParameters queryParameters,
        Metadata metadata,
        TideResult result
) {
    public record QueryParameters(
            String latitude,
            String longitude,
            String fromTime,
            String toTime,
            String referenceCode,
            String language
    ) {}

    public record Metadata(
            LocalDateTime timestamp,
            String elapsedTime
    ) {}

    public record TideResult(
            List<Forecast> forecasts,
            List<DownloadLink> downloadLinks
    ) {}

    public record Forecast(
            String status,
            Measurement measurement,
            OffsetDateTime dateTime,
            Measurement lowPercentile,
            Measurement lowerPercentile,
            Measurement highPercentile,
            Measurement higherPercentile
    ) {}

    public record Measurement(
            Double value,
            String unit
    ) {}

    public record DownloadLink(
            String name,
            String href
    ) {}
}


