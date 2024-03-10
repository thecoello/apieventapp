package com.ApiEvent.web;

import com.ApiEvent.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/validate")
    public ResponseEntity<String> validateTicket(@RequestBody String ticketCode) {
        boolean isValid = ticketService.validateTicket(ticketCode);
        if (isValid) {
            return ResponseEntity.ok("Ticket válido");
        } else {
            return ResponseEntity.badRequest().body("Ticket inválido");
        }
    }
}
