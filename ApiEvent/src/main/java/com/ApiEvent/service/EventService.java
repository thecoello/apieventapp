package com.ApiEvent.service;

import com.ApiEvent.events.Event;
import com.ApiEvent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> listAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        if(event.isPresent()) {
            return event.get();
        } else {
            throw new RuntimeException("Evento no encontrado para el id: " + id);
        }
    }

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
