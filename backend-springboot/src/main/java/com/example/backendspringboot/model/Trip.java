package com.example.backendspringboot.model;

import jakarta.persistence.Column;
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
    @Column(name = "from_city")
    private String fromCity;
    @Column(name = "to_city")
    private String toCity;
    private String date;
    private String time;
    private Double price;
    private String companyName;
}
