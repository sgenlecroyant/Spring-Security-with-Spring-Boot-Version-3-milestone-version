package com.sgenlecroyant.spring.security.auth;

public enum Permission {
	
	RESOURCE_WRITE("resource:write"),
	RESOURCE_READ("resource:read");
	
	private String permission;
	
	private Permission(String permission) {
		this.permission = permission;
	}
	
	public String getPermission() {
		return permission;
	}

}
