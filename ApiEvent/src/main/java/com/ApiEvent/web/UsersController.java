package com.ApiEvent.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.ApiEvent.web.error.ErrorMessage;

@RestController
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@GetMapping(path = "/users")
	List<UserAdmin>getUsers(@RequestParam(required = false) Map<String,String> params){	
		
		List<UserAdmin> findAllUsers = usersService.getUsers();
		
		if(findAllUsers.isEmpty()) {
			throw new ErrorMessage("No hay usuarios registrados");
		}else {
			return findAllUsers;
		}
	}
	
	@GetMapping(path = "/users/{id}")
	UserAdmin getUsers(@PathVariable Long id){				
		if(usersService.getUser(id).isPresent()) {
			return usersService.getUser(id).get();
		}else {
			throw new ErrorMessage("Usuario no encontrado");
		}
	}
	
	@PostMapping(path = "/users")
	Long postUser(@RequestBody UserAdmin user ) {				
		return usersService.postUser(user);		
	}
	
	@PutMapping(path = "/users/{id}")
	Optional<UserAdmin> modificaUser(@RequestBody UserAdmin user,@PathVariable Long id) {
		Optional<UserAdmin> userFind = usersService.getUser(id);
		if(userFind.isPresent()) {
			usersService.putUser(id, user);		
			return userFind;	
		}else {
			throw new ErrorMessage("Usuario no encontrado");
		}
	}
	
	@DeleteMapping(path="/users/{id}")
	String borraUser(@PathVariable Long id) {	
		if(usersService.getUser(id).isPresent()) {
			usersService.deleteUser(id);	
			return("Usuario eliminado");	
		}else {
			throw new ErrorMessage("Usuario no encontrado");
		}
	}
	
}