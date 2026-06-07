package com.example.backendspringboot.repository;

import com.example.backendspringboot.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

}