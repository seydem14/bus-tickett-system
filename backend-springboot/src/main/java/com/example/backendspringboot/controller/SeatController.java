package com.example.backendspringboot.controller;

import com.example.backendspringboot.model.Seat;
import com.example.backendspringboot.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
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