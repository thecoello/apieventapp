package com.ApiEvent.events;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreEvento;

    @Column
    private String image;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFinal;

    @Column(nullable = false)
    private String tipoEvento;

    @Column
    private String enlaceStreaming;

    @Column
    private Integer capacidadEvento;
    
    @Column
    private String direccion; 

    @Column
    private String imageMapaZona; 
    
    @Column(length = 2048)
    private String descripcion; 
    
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Zone> zonas; 

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getEnlaceStreaming() {
        return enlaceStreaming;
    }

    public void setEnlaceStreaming(String enlaceStreaming) {
        this.enlaceStreaming = enlaceStreaming;
    }

    public Integer getCapacidadEvento() {
        return capacidadEvento;
    }

    public void setCapacidadEvento(Integer capacidadEvento) {
        this.capacidadEvento = capacidadEvento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImageMapaZona() {
        return imageMapaZona;
    }

    public void setImageMapaZona(String imageMapaZona) {
        this.imageMapaZona = imageMapaZona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Zone> getZonas() {
        return zonas;
    }

    public void setZonas(List<Zone> zonas) {
        this.zonas = zonas;
    }
}
