package com.example.backendspringboot.service;

import com.example.backendspringboot.model.Trip;
import com.example.backendspringboot.repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

    private final TripRepository tripRepository;

    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public List<Trip> getTrips(String fromCity, String toCity, String date) {
        return tripRepository.findAll()
                .stream()
                .filter(trip -> fromCity == null || fromCity.isEmpty() || trip.getFromCity().equalsIgnoreCase(fromCity))
                .filter(trip -> toCity == null || toCity.isEmpty() || trip.getToCity().equalsIgnoreCase(toCity))
                .filter(trip -> date == null || date.isEmpty() || trip.getDate().equals(date))
                .toList();
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id).orElse(null);
    }

    public Trip createTrip(Trip trip) {
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long id) {
        tripRepository.deleteById(id);
    }

    public Trip updateTrip(Long id, Trip updatedTrip) {
        Trip existingTrip = tripRepository.findById(id).orElse(null);

        if (existingTrip == null) {
            return null;
        }

        existingTrip.setFromCity(updatedTrip.getFromCity());
        existingTrip.setToCity(updatedTrip.getToCity());
        existingTrip.setDate(updatedTrip.getDate());
        existingTrip.setTime(updatedTrip.getTime());
        existingTrip.setPrice(updatedTrip.getPrice());
        existingTrip.setCompanyName(updatedTrip.getCompanyName());

        return tripRepository.save(existingTrip);
    }
}