package com.ApiEvent.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ApiEvent.domain.UserAdmin;
import com.ApiEvent.repository.UserRepository;
import com.ApiEvent.web.error.ErrorMessage;

@Service
public class UsersService {

	private PasswordEncoder passwordEncoder;

	UserRepository userRepository;

	public UsersService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;

	}

	public List<UserAdmin> getUsers() {
		return userRepository.findAll();
	}

	public Optional<UserAdmin> getUser(Long id) {
		return userRepository.findById(id);
	}

	public Long postUser(UserAdmin user) {

		UserAdmin _user = user;
		String encryptPass = passwordEncoder.encode(user.getPassword());

		_user.setPassword(encryptPass);

		UserAdmin saveUser = userRepository.save(_user);
		userRepository.save(saveUser);
		return saveUser.getId();
	}

	public Optional<UserAdmin> putUser(Long id, UserAdmin user) {
		userRepository.findById(id).ifPresent(_user -> {

			String encryptPass = passwordEncoder.encode(user.getPassword());

			_user.setNombre(user.getNombre());
			_user.setApellido(user.getApellido());
			_user.setEmail(user.getEmail());
			_user.setUsuario(user.getUsuario());
			_user.setPassword(encryptPass);

			userRepository.save(_user);
		});

		return userRepository.findById(id);
	}

	public Optional<UserAdmin> deleteUser(Long id) {
		userRepository.deleteById(id);
		return userRepository.findById(id);
	}

	public UserAdmin updateResetPasswordToken(String token, String email) {
		UserAdmin _user = userRepository.findByEmail(email);
		
		if(_user != null) {
			_user.setResetPasswordToken(token);
			return userRepository.save(_user);
		}else {
			return null;
		}
	
		
	}
	
	  public UserAdmin getByResetPasswordToken(String token) {
	        return userRepository.findByResetPasswordToken(token);
	    }
	  
	  public void updatePassword(UserAdmin user, String newPassword) {
		  
			String encryptPass = passwordEncoder.encode(newPassword);

	        String encodedPassword = passwordEncoder.encode(encryptPass);
	        user.setPassword(encodedPassword);
	         
	        user.setResetPasswordToken(null);
	        userRepository.save(user);
	    }
	  
		public UserAdmin findByEmail(String email){
			return userRepository.findByEmail(email);	
		}
		
		public UserAdmin findByUsuario(String usuario){
			return userRepository.findByUsuario(usuario);
		}
			
		
		
		public UserAdmin findByResetPasswordToken(String token) {
			return userRepository.findByResetPasswordToken(token);

		}

}
