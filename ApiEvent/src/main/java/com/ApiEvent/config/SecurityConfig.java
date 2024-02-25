package com.ApiEvent.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig   {
	
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
        http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests((authz) -> authz
                    .requestMatchers(HttpMethod.POST, "/users").permitAll()
                    .anyRequest().hasAnyRole("ADMIN")
            )
            .httpBasic(Customizer.withDefaults());
     
        return http.build();
    }
    
    @Bean
    public UserDetailsService inMemoryUserDetailsManager() {
    	
      UserDetails admin = User.builder()
          .username("admin")
          .password(passwordEncoder().encode("password"))
          .roles("ADMIN")
          .build();
      
      return new InMemoryUserDetailsManager(admin);
    }

    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	 

}
