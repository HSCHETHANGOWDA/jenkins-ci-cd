package com.javatechie.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class SecurityConfiguration {

	// This is the UserDetailsService class provided by the Spring security to
	// maintain the users
	// User and UserDetails where we will add the individual users
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails userDetails = User.withUsername("chethan").password(passwordEncoder.encode("Gow@123Vasu"))
				.roles("ADMIN").build();

		UserDetails userDetails1 = User.withUsername("chethan1").password(passwordEncoder.encode("Gow@123Vasu1"))
				.roles("ADMIN", "USER").build();

		UserDetails userDetails2 = User.withUsername("chethan2").password(passwordEncoder.encode("Gow@123Vasu2"))
				.roles("USER").build();
		return new InMemoryUserDetailsManager(userDetails, userDetails1, userDetails2);
	}

	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		 return httpSecurity.csrf().disable()
	                .authorizeHttpRequests()
	                .requestMatchers("/greetings").permitAll()
	                .and()
	                .authorizeHttpRequests().requestMatchers("/user/**").authenticated()	                
	                .and().httpBasic()
	                .and().build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
