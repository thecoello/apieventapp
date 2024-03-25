package com.ApiEvent.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private Long userAdminId;

    @Column(nullable = false)
	@NotBlank(message = "El Nombre de evento es requerido")
    private String nombre;

    @Column
    private String image;
    
    @Column(nullable = false)
	@NotBlank(message = "El tipo de evento es requerido")
    private String tipoEvento;
    
    @Column(length = 2048)
    private String descripcion; 

    @Column(nullable = false)
    @NotNull(message = "La fecha y hora del inicio del evento es requerido")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date fechaInicio;

    @Column(nullable = false)
    @NotNull(message = "La fecha y hora del final del evento es requerido")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm")
    private Date fechaFinal;

    @Column
    private String enlaceStreaming;

    @Column
    private Integer capacidadEvento;
    
    @Column
    private String direccion; 

    @Column
    private String imageMapaZona; 
    
    @OneToMany(cascade = CascadeType.ALL)
    private List<Zone> zonas = new ArrayList<Zone>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserAdminId() {
		return userAdminId;
	}

	public void setUserAdminId(Long userAdminId) {
		this.userAdminId = userAdminId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public List<Zone> getZonas() {
		return zonas;
	}

	public void setZonas(List<Zone> zonas) {
		this.zonas = zonas;
	}
	

}
