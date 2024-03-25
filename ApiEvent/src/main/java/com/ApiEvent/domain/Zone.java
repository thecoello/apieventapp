package com.ApiEvent.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombreZona;
 
    @Column
    private Long cantidadDeTickets;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreZona() {
		return nombreZona;
	}

	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	public Long getCantidadDeTickets() {
		return cantidadDeTickets;
	}

	public void setCantidadDeTickets(Long cantidadDeTickets) {
		this.cantidadDeTickets = cantidadDeTickets;
	}

}
