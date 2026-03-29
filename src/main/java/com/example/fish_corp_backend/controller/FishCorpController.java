package com.example.fish_corp_backend.controller;

import com.example.fish_corp_backend.model.TideForecast;
import com.example.fish_corp_backend.model.WaterTempForecast;
import com.example.fish_corp_backend.service.KartverketService;
import com.example.fish_corp_backend.service.MapperService;
import com.example.fish_corp_backend.service.VanntempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FishCorpController {

    @Autowired
    MapperService mapperService;

    @Autowired
    VanntempService vanntempService;

    @Autowired
    KartverketService kartverketService;

    @GetMapping(value = "/tidevann")
    public TideForecast getTidevann() {
        var tideForecast = mapperService.mapTideForecastFromDto(kartverketService.getTideForecast("65.4691", "12.2042"));

        return tideForecast;
    }

    @GetMapping(value = "/oceanforecast")
    public WaterTempForecast getOceanForecast() {
        var oceanForecast =  mapperService.mapOceanForecastFromDto(vanntempService.getOceanForecast("65.4691", "12.2042"));

        return oceanForecast;
    }
}
