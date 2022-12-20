package com.sgenlecroyant.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) {
		try {
			SecurityFilterChain securityFilterChain = httpSecurity.csrf().disable().headers().frameOptions().disable()
					.and().authorizeHttpRequests().anyRequest().permitAll().and().httpBasic().and().build();
			return securityFilterChain;
		} catch (Exception e) {
			throw new RuntimeException(
					"Error building SecurityFilderChain bean, could not configure security related stuffs");
		}

	}

}
