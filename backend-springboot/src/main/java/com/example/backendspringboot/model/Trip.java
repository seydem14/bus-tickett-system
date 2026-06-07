package com.example.backendspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="trips")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {
    @Id
    private Long id;
    private String fromCity;
    private String toCity;
    private String date;
    private String time;
    private Double price;
    private String companyName;
}
