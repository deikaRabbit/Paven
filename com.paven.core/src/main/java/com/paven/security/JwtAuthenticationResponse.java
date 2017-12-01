package com.paven.security;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5949118518001003469L;

	private String username;
	private Short privilege;
	private final String token;

	public JwtAuthenticationResponse(String userName, Short role, String token) {
		this.username = userName;
		this.privilege = role;
		this.token = token;
	}

	public String getUsername() {
		return username;
	}
	
	public Short getPrivilege() {
		return privilege;
	}

	public String getToken() {
		return this.token;
	}
}
