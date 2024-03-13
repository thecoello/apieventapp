package com.ApiEvent.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserAdmin {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @NotBlank(message = "El nombre es requerido")		
    private String nombre;
    
    @NotBlank(message = "El Apellido es requerido")	
    private String apellido;
    
    @Email
    @NotBlank(message = "El Email es requerido")
    @Column(unique=true)
    private String email;
    
	@NotBlank(message = "El Usuario es requerido")
    @Column(unique=true)
    private String usuario;
    
    @NotBlank(message = "El Password es requerido")		
    private String password;
    
    @NotBlank(message = "Aceptar los terminos de uso es requerido")		
    private String userterms;
    
    private String userRole = "ADMIN";
    
    private String resetPasswordToken;
    
   
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
    public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
    @JsonProperty(access = Access.WRITE_ONLY)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserTerms() {
		return userterms;
	}
	public void setUserTerms(String userTerms) {
		userterms = userTerms;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getResetPasswordToken() {
		return resetPasswordToken;
	}
	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}		
}