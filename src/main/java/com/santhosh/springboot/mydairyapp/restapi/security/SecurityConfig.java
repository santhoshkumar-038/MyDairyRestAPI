package com.santhosh.springboot.mydairyapp.restapi.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;


@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsManager configureDataSource(DataSource dataSource) {
		UserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);
		return userDetailsManager;
	}
	
	/*
	@Bean
	//it is recommended when ever user are less and only for testing purposes.
	public InMemoryUserDetailsManager getDetails() {
		
		UserDetails user1 = User.builder().username("santhosh").password("{noop}12345").roles("ADMIN").build();
		UserDetails user2 = User.builder().username("user2").password("{noop}12345").roles("MANAGER", "EMPLOYEE").build();
		UserDetails user3 = User.builder().username("user3").password("{noop}12345").roles("EMPLOYEE").build();
		
		InMemoryUserDetailsManager inMemoryUserDetails = new InMemoryUserDetailsManager(user1, user2, user3);
		return inMemoryUserDetails;
	}
	*/
}
