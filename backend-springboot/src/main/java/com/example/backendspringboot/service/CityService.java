package com.example.backendspringboot.service;

import com.example.backendspringboot.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    public List<City> getCities() {
        return List.of(
                new City(1L, "Ankara"),
                new City(2L, "İstanbul"),
                new City(3L, "İzmir")
        );
    }
}