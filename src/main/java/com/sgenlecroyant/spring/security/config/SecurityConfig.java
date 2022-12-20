package com.sgenlecroyant.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final PasswordEncoder passwordEncoder;

	public SecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Bean
	public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) {
		try {
			SecurityFilterChain securityFilterChain = httpSecurity.csrf().disable().headers().frameOptions().disable()
					.and().authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/api/v*/books").hasRole("ADMIN")
					.requestMatchers(HttpMethod.GET, "/api/v*/books/**").permitAll().anyRequest().authenticated().and()
					.httpBasic().and().build();

			return securityFilterChain;
		} catch (Exception e) {
			throw new RuntimeException(
					"Error building SecurityFilderChain bean, could not configure security related stuffs: "
							+ e.getMessage());
		}

	}

	@Bean
	public UserDetailsManager getUserDetailsService() {
		UserDetails admin = User.builder().accountExpired(false).accountLocked(false).credentialsExpired(false)
				.disabled(false).password(this.passwordEncoder.encode("password")).username("admin").roles("ADMIN")
				.build();

		UserDetails regularUser = User.builder().accountExpired(false).accountLocked(false).credentialsExpired(false)
				.disabled(false).password(this.passwordEncoder.encode("password")).username("regular").roles("REGULAR")
				.build();
		return new InMemoryUserDetailsManager(admin, regularUser);
	}

}
