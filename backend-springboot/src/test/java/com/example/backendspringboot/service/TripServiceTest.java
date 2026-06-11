package com.example.backendspringboot.service;

import com.example.backendspringboot.model.Trip;
import com.example.backendspringboot.repository.TripRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TripServiceTest {

    @Test
    void shouldReturnFilteredTrips() {
        TripRepository tripRepository = mock(TripRepository.class);
        TripService tripService = new TripService(tripRepository);

        Trip trip = new Trip();
        trip.setId(1L);
        trip.setFromCity("Ankara");
        trip.setToCity("İstanbul");
        trip.setDate("2026-06-10");
        trip.setTime("10:00");
        trip.setPrice(800.0);
        trip.setCompanyName("Metro");

        when(tripRepository.findAll()).thenReturn(List.of(trip));

        List<Trip> result = tripService.getTrips(
                "Ankara",
                "İstanbul",
                "2026-06-10"
        );

        assertEquals(1, result.size());
        assertEquals("Ankara", result.get(0).getFromCity());
        assertEquals("İstanbul", result.get(0).getToCity());
        assertEquals("2026-06-10", result.get(0).getDate());
        assertEquals(800, result.get(0).getPrice());
        assertEquals("Metro", result.get(0).getCompanyName());

        verify(tripRepository).findAll();
    }
}