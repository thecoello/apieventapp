package com.ApiEvent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApiEvent.domain.UserAdmin;

@Repository
public interface UserRepository extends JpaRepository<UserAdmin, Long>{
	 UserAdmin findByEmail(String email);
	 UserAdmin findByUsuario(String usuario);
	 UserAdmin findByResetPasswordToken(String token);
	
	 
}
