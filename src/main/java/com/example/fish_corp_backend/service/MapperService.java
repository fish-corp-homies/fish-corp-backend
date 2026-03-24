package com.example.fish_corp_backend.service;

import com.example.fish_corp_backend.dto.OceanForecastResponse;
import com.example.fish_corp_backend.dto.TideForecastResponse;
import com.example.fish_corp_backend.model.TideForecast;
import com.example.fish_corp_backend.model.WaterTempForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MapperService {

    public WaterTempForecast mapOceanForecastFromDto(OceanForecastResponse oceanForecastResponse) {
        return new WaterTempForecast(
                oceanForecastResponse.properties().meta().updatedAt(),
                oceanForecastResponse.properties().timeseries().getFirst().data().instant().details().seaWaterTemperature());
    }

    public TideForecast mapTideForecastFromDto(TideForecastResponse tideForecastResponse) {
        List<TideForecast.Forecast> modelForecasts = tideForecastResponse.result().forecasts().stream()
                .map(dto -> new TideForecast.Forecast(
                        dto.status(),
                        dto.dateTime().toInstant(),
                        new TideForecast.Measurement(
                                dto.measurement().value(),
                                dto.measurement().unit()
                        )
                ))
                .collect(Collectors.toList());

        return new TideForecast(modelForecasts);
    }

}
