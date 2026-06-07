package com.example.backendspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    private Long id;
    private String fromCity;
    private String toCity;
    private String date;
    private String time;
    private Double price;
    private String companyName;
}
