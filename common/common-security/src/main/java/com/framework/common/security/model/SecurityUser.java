package com.framework.common.security.model;

import java.util.Set;

public class SecurityUser {

	private String username;
	
	private String password;
	
	private Set<String> roleCodes;
	
	private Set<SecurityRole> roles;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRoleCodes() {
		return roleCodes;
	}

	public void setRoleCodes(Set<String> roleCodes) {
		this.roleCodes = roleCodes;
	}

	public Set<SecurityRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<SecurityRole> roles) {
		this.roles = roles;
	}
	
}
