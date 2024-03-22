package com.ApiEvent.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ApiEvent.domain.Event;
import com.ApiEvent.domain.UserAdmin;
import com.ApiEvent.domain.Zone;
import com.ApiEvent.repository.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class EventService {

	EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public List<Event> getEvents() {
		return eventRepository.findAll();
	}

	public Optional<Event> getEvent(Long id) {
		return eventRepository.findById(id);
	}

	public Long postEvent(Map<String, String> eventParam, MultipartFile image, MultipartFile imageMapaZona) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		String zonas = "zonas";		
		List<Zone> zones = new ArrayList<Zone>();

		JsonObject convertedObject = new Gson().fromJson(eventParam.get(zonas).toString(), JsonObject.class);
		
		JsonArray result = convertedObject.get("zonas").getAsJsonArray();
		
		for (JsonElement jsonElement : result) {
			Zone zone = new Gson().fromJson(jsonElement.toString(), Zone.class);
			zones.add(zone);
		}	
	
		eventParam.remove(zonas);
		
		Event event = objectMapper.convertValue(eventParam, Event.class);		
		event.setZonas(zones);

		if (!image.isEmpty()) {

			try {
				String pathToFile = "static/uploads/imagesevents/" + event.getNombre().replaceAll("\\s+", "_")+ "_" +  image.getOriginalFilename().replaceAll("\\s+", "_");
				File newFile = new File(pathToFile );
				image.transferTo(newFile.toPath());
				event.setImage("/uploads/imagesevents/" + event.getNombre().replaceAll("\\s+", "_")+ "_" +  image.getOriginalFilename().replaceAll("\\s+", "_"));					
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (!imageMapaZona.isEmpty()) {

			try {
				String pathToFile = "static/uploads/imagesmaps/" + event.getNombre().replaceAll("\\s+", "_")+ "_" +  imageMapaZona.getOriginalFilename().replaceAll("\\s+", "_");
				File newFile = new File(pathToFile );
				imageMapaZona.transferTo(newFile.toPath());
				event.setImageMapaZona("/uploads/imagesmaps/" + event.getNombre().replaceAll("\\s+", "_")+ "_" +  imageMapaZona.getOriginalFilename().replaceAll("\\s+", "_"));					
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Event saveEvent = eventRepository.save(event);
		return saveEvent.getId();
	}

	public Optional<Event> putEvent(Long id, Event event) {
		eventRepository.findById(id).ifPresent(_event -> {

			_event.setNombre(event.getNombre());
			_event.setImage(event.getImage());
			_event.setTipoEvento(event.getTipoEvento());
			_event.setDescripcion(event.getDescripcion());
			_event.setFechaInicio(event.getFechaInicio());
			_event.setFechaFinal(event.getFechaFinal());
			_event.setEnlaceStreaming(event.getEnlaceStreaming());
			_event.setCapacidadEvento(event.getCapacidadEvento());
			_event.setDireccion(event.getDireccion());
			_event.setImageMapaZona(event.getImageMapaZona());
			_event.setZonas(event.getZonas());

		});

		return eventRepository.findById(id);
	}

	public Optional<Event> deleteEvent(Long id) {
		eventRepository.deleteById(id);
		return eventRepository.findById(id);
	}

}
