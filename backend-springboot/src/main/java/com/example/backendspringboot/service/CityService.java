package com.example.backendspringboot.service;

import com.example.backendspringboot.model.City;
import com.example.backendspringboot.repository.CityRepository;
import com.example.backendspringboot.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCities() {

        return cityRepository.findAll().stream().toList();
//        return List.of(
//                new City(1L, "Ankara"),
//                new City(2L, "İstanbul"),
//                new City(3L, "İzmir")
//        );
    }
}