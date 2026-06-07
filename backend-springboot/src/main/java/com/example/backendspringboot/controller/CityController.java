package com.example.backendspringboot.controller;

import com.example.backendspringboot.model.City;
import com.example.backendspringboot.service.CityService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class CityController {

    public final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/api/cities")
    public List<City> getCities() {
        return cityService.getCities();
    }



}