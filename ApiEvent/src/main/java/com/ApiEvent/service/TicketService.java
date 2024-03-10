package com.ApiEvent.service;

import com.ApiEvent.events.Ticket;
import com.ApiEvent.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public boolean validateTicket(String ticketCode) {
        Ticket ticket = ticketRepository.findByCode(ticketCode);
        if (ticket != null && ticket.isValid()) {
            return true;
        }
        return false;
    }
}
