package com.example.backendspringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    private Long id;
    private Long tripId;
    private Integer seatNumber;
    private String passengerName;
}