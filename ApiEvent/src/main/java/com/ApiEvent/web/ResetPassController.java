package com.ApiEvent.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ApiEvent.domain.UserAdmin;
import com.ApiEvent.service.MailService;
import com.ApiEvent.service.UsersService;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import net.bytebuddy.utility.RandomString;

@Controller
public class ResetPassController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private MailService mailService = new MailService();

	
	@PostMapping("/forgot_password")
	public ResponseEntity<String> processForgotPassword(HttpServletRequest request) {
	    String email = request.getParameter("email");
	    String token = RandomString.make(30);
	    
	    System.out.print("Esto es el email" + email);
	     
	    try {
	    	usersService.updateResetPasswordToken(token, email);
	        String resetPasswordLink =  "http://localhost:8080/reset_password?token=" + token;
	        mailService.sendSimpleMessage(email, "Recuperación de contraseña", resetPasswordLink);
	        
	    	return ResponseEntity.ok("Email de recuperación de password enviado");
	         
	    } catch (Exception error) {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email no encontrado");
	    } 	         
	}
	
	@PostMapping("/reset_password")
	public ResponseEntity<String> processResetPassword(HttpServletRequest request, Model model) {
	    String token = request.getParameter("token");
	    String password = request.getParameter("password");
	     
	    UserAdmin _user = usersService.getByResetPasswordToken(token);
	     
	    if (_user == null) {
	    	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
	    } else {           
	    	usersService.updatePassword(_user, password);
	    	return ResponseEntity.ok("Password actualizado con éxito");
	    }
	     
	}

}