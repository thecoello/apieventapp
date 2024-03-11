package com.ApiEvent.ApiEvent;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ApiEvent.domain.Event;
import com.ApiEvent.repository.EventRepository;
import com.ApiEvent.service.EventService;

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
    
    /*

    @Test
    void saveEventWithoutNameThrowsException() {
        assertThrows(RuntimeException.class, () -> {
            event.setNombreEvento(null); 
            eventService.saveEvent(event);
        });
    }*/

   /* @Test
    void saveEventWithAllRequiredFieldsSucceeds() {
        event.setNombreEvento("Evento de Prueba");
        when(eventRepository.save(any(Event.class))).thenReturn(event);
        Event savedEvent = eventService.saveEvent(event);
        assertNotNull(savedEvent);
        assertEquals("Evento de Prueba", savedEvent.getNombreEvento());
    }*/

}
