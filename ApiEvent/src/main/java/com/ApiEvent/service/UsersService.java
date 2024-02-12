package com.ApiEvent.service;
//manu
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ApiEvent.domain.UserAdmin;
import com.ApiEvent.repository.UserRepository;

@Service
public class UsersService {
	
	UserRepository userRepository;

	public UsersService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<UserAdmin> getUsers(){
		return userRepository.findAll();
	}
	
	public Optional<UserAdmin> getUser(Long id){
		return userRepository.findById(id);
	}
	
	public Long postUser(UserAdmin user){
		UserAdmin saveUser = userRepository.save(user);
		userRepository.save(saveUser);
		return saveUser.getId();
	}
		
	public Optional<UserAdmin> putUser(Long id, UserAdmin user) {
		userRepository.findById(id)
		.ifPresent(_user -> {
			_user.setNombre(user.getNombre());
			_user.setApellido(user.getApellido());
			_user.setEmail(user.getEmail());
			_user.setUsuario(user.getUsuario());
			_user.setPassword(user.getPassword());
			userRepository.save(_user);
		});
		
		return userRepository.findById(id);
	}
	
	public Optional<UserAdmin> deleteUser(Long id) {
		userRepository.deleteById(id);
		return userRepository.findById(id);
	}
	  
	

}
