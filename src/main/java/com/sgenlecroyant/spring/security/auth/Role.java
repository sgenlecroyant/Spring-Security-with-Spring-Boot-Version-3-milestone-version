package com.sgenlecroyant.spring.security.auth;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

	ADMIN_USER(Set.<Permission>of(Permission.RESOURCE_WRITE, Permission.RESOURCE_READ)),
	REGULAR_USER(Set.<Permission>of());

	private Set<Permission> permissions;

	private Role(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public Set<GrantedAuthority> getGrantedAuthorities() {
		Set<GrantedAuthority> grantedAuthorities = this.permissions.stream()
				.map((permission) -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());

		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

		return grantedAuthorities;
	}

}
