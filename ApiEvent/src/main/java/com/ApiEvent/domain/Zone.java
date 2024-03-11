package com.ApiEvent.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreZona", nullable = false)
    private String nombreZona;

    @Column(name = "cantidadDeTickets")
    private String cantidadDeTickets;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Zone() {
    }

    // Getters y setters

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

    public String getCantidadDeTickets() {
        return cantidadDeTickets;
    }

    public void setCantidadDeTickets(String cantidadDeTickets) {
        this.cantidadDeTickets = cantidadDeTickets;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

}
