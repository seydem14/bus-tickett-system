package com.example.backendspringboot.controller;

import com.example.backendspringboot.model.Trip;
import com.example.backendspringboot.service.TripService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(TripController.class)
class TripControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TripService tripService;

    @Test
    void shouldReturnTrips() throws Exception {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setFromCity("Ankara");
        trip.setToCity("İstanbul");
        trip.setDate("2026-06-10");
        trip.setTime("10:00");
        trip.setPrice(800.0);
        trip.setCompanyName("Metro");

        when(tripService.getTrips(
                "Ankara",
                "İstanbul",
                "2026-06-10"
        )).thenReturn(List.of(trip));

        mockMvc.perform(get("/api/trips")
                        .param("fromCity", "Ankara")
                        .param("toCity", "İstanbul")
                        .param("date", "2026-06-10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].fromCity").value("Ankara"))
                .andExpect(jsonPath("$[0].toCity").value("İstanbul"))
                .andExpect(jsonPath("$[0].date").value("2026-06-10"))
                .andExpect(jsonPath("$[0].time").value("10:00"))
                .andExpect(jsonPath("$[0].price").value(800.0))
                .andExpect(jsonPath("$[0].companyName").value("Metro"));
    }
}