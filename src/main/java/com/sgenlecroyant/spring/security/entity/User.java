package com.sgenlecroyant.spring.security.entity;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sgenlecroyant.spring.security.auth.Role;
import com.sgenlecroyant.spring.security.builder.SecurityUserBuilder;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@SuppressWarnings("serial")
@Entity(name = "users")
@Table(name = "users")
public class User implements Serializable, UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	private Role role;

	public User(SecurityUserBuilder builder) {
		this.firstName = builder.getFirstName();
		this.lastName = builder.getLastName();
		this.username = builder.getUsername();
		this.password = builder.getPassword();
		this.isAccountNonExpired = builder.isAccountNonExpired();
		this.isAccountNonLocked = builder.isAccountNonLocked();
		this.isCredentialsNonExpired = builder.isCredentialsNonExpired();
		this.isEnabled = builder.isEnabled();
		this.role = builder.getRole();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> grantedAuthorities = 
				this.getRole().getGrantedAuthorities();
		return grantedAuthorities;
	}

	public String getFirstName() {
		return firstName;
	}

	public Integer getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public Role getRole() {
		return role;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.isEnabled;
	}

	public static SecurityUserBuilder newBuilder() {
		return new SecurityUserBuilder();
	}

}
