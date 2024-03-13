package com.ApiEvent.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ApiEvent.domain.UserAdmin;
import com.ApiEvent.service.UsersService;

import jakarta.validation.Valid;

@CrossOrigin(origins ="http://localhost:4200") 
@RestController
public class UsersController {
	
	@Autowired
	UsersService usersService;

	@GetMapping(path = "/users")
	ResponseEntity<Object>getUsers(@RequestParam(required = false) Map<String,String> params){	
		
		List<UserAdmin> findAllUsers = usersService.getUsers();
		
		if(findAllUsers.isEmpty()) {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay usuarios registrados");
		}else {
	    	 return ResponseEntity.status(HttpStatus.OK).body(findAllUsers);
		}
	}
	
	@GetMapping(path = "/users/{id}")
	ResponseEntity<Object> getUser(@PathVariable Long id){				
		if(usersService.getUser(id).isPresent()) {
	    	 return ResponseEntity.status(HttpStatus.OK).body(usersService.getUser(id).get());
		}else {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no creado");
		}
	}
	
	@PostMapping(path = "/users")
	ResponseEntity<Object> postUser(@RequestBody @Valid UserAdmin user ) {		

		
		if(usersService.findByEmail(user.getEmail())  != null || usersService.findByUsuario(user.getUsuario())  != null){
	    	 return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuario ya existe");
		}else {
			Long createUser = usersService.postUser(user);
			Optional<UserAdmin> userCreated = usersService.getUser(createUser);
			if(userCreated.isPresent()) {
		    	 return ResponseEntity.status(HttpStatus.OK).body(userCreated);
			}else {
		    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no creado");
			}
		}
	}
	
	@PutMapping(path = "/users/{id}")
	ResponseEntity<Object> modificaUser(@RequestBody UserAdmin user,@PathVariable Long id) {
		Optional<UserAdmin> userFind = usersService.getUser(id);
		if(usersService.getUser(id).isPresent()) {
			usersService.putUser(id, user);		
	    	 return ResponseEntity.status(HttpStatus.OK).body("Usuario actualizado");
		}else {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no se ha podido actualizar");
		}
	}
	
	@DeleteMapping(path="/users/{id}")
	ResponseEntity<String> borraUser(@PathVariable Long id) {	
		if(usersService.getUser(id).isPresent()) {
			usersService.deleteUser(id);	
			return ResponseEntity.ok("Usuario eliminado");
		}else {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
		}
	}
	
}