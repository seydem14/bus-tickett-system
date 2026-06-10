package com.example.backendspringboot.repository;

import com.example.backendspringboot.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}