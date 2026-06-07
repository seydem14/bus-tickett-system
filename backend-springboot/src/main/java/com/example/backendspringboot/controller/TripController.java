package com.example.backendspringboot.controller;

import com.example.backendspringboot.model.Trip;
import com.example.backendspringboot.service.TripService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class TripController {

    private final TripService tripService;

    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/api/trips")
    public List<Trip> getTrips(
            @RequestParam(required = false) String fromCity,
            @RequestParam(required = false) String toCity,
            @RequestParam(required = false) String date
    ) {
        return tripService.getTrips(fromCity, toCity, date);
    }

    @GetMapping("/api/trips/{id}")
    public Trip getTripById(@PathVariable Long id) {
        return tripService.getTripById(id);
    }

//    @GetMapping("/api/trips")
//    public List<Trip> getTrips() {
//        return tripService.getTrips();
//    }
}