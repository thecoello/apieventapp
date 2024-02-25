package com.ApiEvent.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class UserAdmin {
		
	@Id
	@GeneratedValue
	private Long id;
	
    @NotBlank(message = "El nombre es requerido")		
    private String Nombre;
    
    @NotBlank(message = "El Apellido es requerido")	
    private String Apellido;
    
    @NotBlank(message = "El Email es requerido")
    @Column(unique=true)
    private String Email;
    
    @NotBlank(message = "El Usuario es requerido")
    @Column(unique=true)
    private String Usuario;
    
    @NotBlank(message = "El Password es requerido")		
    private String Password;
    
    @NotBlank(message = "Aceptar los terminos de uso es requerido")		
    private String Userterms;
    
    private String UserRole = "ADMIN";
    
   
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}	
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getUserTerms() {
		return Userterms;
	}
	public void setUserTerms(String userTerms) {
		Userterms = userTerms;
	}
	public String getUserRole() {
		return UserRole;
	}
	public void setUserRole(String userRole) {
		UserRole = userRole;
	}		
}