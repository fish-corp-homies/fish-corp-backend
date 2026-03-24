package com.example.fish_corp_backend.controller;

import com.example.fish_corp_backend.service.VanntempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FishCorpController {

    @Autowired
    VanntempService vanntempService;

    @GetMapping(value = "/hello")
    public String sayHello() {
        return vanntempService.getVanntemp("65.4691", "12.2042");
    }
}
