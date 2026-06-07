package com.example.backendspringboot.service;

import com.example.backendspringboot.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    public Ticket createTicket(Ticket ticket) {
        ticket.setId(1L);
        return ticket;
    }
}