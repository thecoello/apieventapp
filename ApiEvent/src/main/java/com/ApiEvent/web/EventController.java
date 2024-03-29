package com.ApiEvent.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ApiEvent.domain.Event;
import com.ApiEvent.service.EventService;

@CrossOrigin(origins ="http://localhost:4200") 
@RestController
public class EventController {

	@Autowired
	private EventService eventService;

	@GetMapping(path = "/events")
	ResponseEntity<Object> getEvents(@RequestParam(required = false) Map<String, String> params) {

		List<Event> findAllEvents = eventService.getEvents();

		if (findAllEvents.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay eventos registrados");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(findAllEvents);
		}
	}

	@GetMapping(path = "/events/{id}")
	ResponseEntity<Object> getEvent(@PathVariable Long id) {
		if (eventService.getEvent(id).isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(eventService.getEvent(id).get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento no creado");
		}
	}

	@PostMapping(path = "/events", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<Object> postEvent(@RequestParam Map<String, String> eventParam,
			@RequestParam("image") MultipartFile image, MultipartFile imageMapaZona) {

		Long createEvent = eventService.postEvent(eventParam, image, imageMapaZona);
		Optional<Event> eventCreated = eventService.getEvent(createEvent);
		if (eventCreated.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(eventCreated);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento no creado");
		}

	}

	@PutMapping(path = "/events/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	ResponseEntity<Object> putEvent(@RequestParam Map<String, String> eventParam,
			@RequestParam("image") MultipartFile image, @RequestParam("imageMapaZona") MultipartFile imageMapaZona, @PathVariable Long id) {
		Optional<Event> eventFind = eventService.getEvent(id);
		if (eventFind.isPresent()) {
			eventService.putEvent(id, eventParam, image, imageMapaZona);
			return ResponseEntity.status(HttpStatus.OK).body(eventFind);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El evento no se ha podido actualizar");
		}
	}

	@DeleteMapping(path = "/events/{id}")
	ResponseEntity<String> deleteEvent(@PathVariable Long id) {
		if (eventService.getEvent(id).isPresent()) {
			eventService.deleteEvent(id);
			return ResponseEntity.ok("Evento eliminado");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Evento no encontrado");
		}
	}

}