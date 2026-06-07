package com.example.backendspringboot.service;

import com.example.backendspringboot.model.Trip;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    public List<Trip> getTrips(String fromCity, String toCity, String date) {
        return List.of(
                        new Trip(1L, "Ankara", "İstanbul", "2026-06-10", "09:00", 750.0, "Metro Turizm"),
                        new Trip(2L, "Ankara", "İstanbul", "2026-06-10", "13:30", 800.0, "Kamil Koç"),
                        new Trip(3L, "İstanbul", "Ankara", "2026-06-11", "10:00", 780.0, "Pamukkale")
                ).stream()
                .filter(trip -> fromCity == null || trip.getFromCity().equalsIgnoreCase(fromCity))
                .filter(trip -> toCity == null || trip.getToCity().equalsIgnoreCase(toCity))
                .filter(trip -> date == null || trip.getDate().equals(date))
                .toList();
    }

    public Trip getTripById(Long id){
        return getTrips(null,null,null)
                .stream()
                .filter(trip -> trip.getId().equals(id))
                .findFirst()
                .orElse(null);

    }





}