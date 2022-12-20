package com.sgenlecroyant.spring.security.builder;

import com.sgenlecroyant.spring.security.auth.Role;
import com.sgenlecroyant.spring.security.entity.User;

public class SecurityUserBuilder {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	private Role role;
	
	public SecurityUserBuilder() {
	}
	
	public SecurityUserBuilder accountNonExpired(boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
		return this;
	}
	
	public SecurityUserBuilder accountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
		return this;
	}
	
	public User build() {
		return new User(this);
	}
	
	public SecurityUserBuilder credentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		return this;
	}
	
	public SecurityUserBuilder enabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
		return this;
	}
	
	public SecurityUserBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public SecurityUserBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public SecurityUserBuilder username(String username) {
		this.username = username;
		return this;
	}

}
