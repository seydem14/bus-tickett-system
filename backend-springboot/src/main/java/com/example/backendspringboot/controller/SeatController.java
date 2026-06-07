package com.example.backendspringboot.controller;

import com.example.backendspringboot.model.Seat;
import com.example.backendspringboot.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/api/trips/{tripId}/seats")
    public List<Seat> getSeatsByTripId(@PathVariable Long tripId) {
        return seatService.getSeatsByTripId(tripId);
    }

}