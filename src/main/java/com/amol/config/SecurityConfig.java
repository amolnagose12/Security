package com.amol.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.codec.Encoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails admin = User.withUsername("Amol")
				.password(passwordEncoder().encode("pwd"))
				.roles("ADMIN")
				.build();
		
		UserDetails user = User.withUsername("John")
				.password(passwordEncoder().encode("pwd2"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin, user);
		
	}
		
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		return http
				.csrf()
				.disable()
				.authorizeHttpRequests()
				.requestMatchers("/product/welcome","product/new")
				.permitAll()
				.and()
				.authorizeHttpRequests().requestMatchers("/product/***")
				.authenticated().and().formLogin().and().build();
		}

}
