package com.ApiEvent.ApiEvent;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.ApiEvent.events.Event;
import com.ApiEvent.repository.EventRepository;
import com.ApiEvent.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    private Event event;

    @BeforeEach
    void setUp() {
        event = new Event();
        // Preset some default values
        event.setFechaInicio(new Date());
        event.setFechaFinal(new Date());
        event.setTipoEvento("Online");
    }

    @Test
    void saveEventWithoutNameThrowsException() {
        assertThrows(RuntimeException.class, () -> {
            event.setNombreEvento(null); 
            eventService.saveEvent(event);
        });
    }

    @Test
    void saveEventWithAllRequiredFieldsSucceeds() {
        event.setNombreEvento("Evento de Prueba");
        when(eventRepository.save(any(Event.class))).thenReturn(event);
        Event savedEvent = eventService.saveEvent(event);
        assertNotNull(savedEvent);
        assertEquals("Evento de Prueba", savedEvent.getNombreEvento());
    }

}
