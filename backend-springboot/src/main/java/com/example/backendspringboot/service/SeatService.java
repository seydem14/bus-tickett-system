package com.example.backendspringboot.service;

import com.example.backendspringboot.model.Seat;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    public List<Seat> getSeatsByTripId(Long tripId) {
        return List.of(
                new Seat(1, true),
                new Seat(2, true),
                new Seat(3, false),
                new Seat(4, true),
                new Seat(5, false)
        );
    }
}
