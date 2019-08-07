package com.cts.sbcrud.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {


	private static final long serialVersionUID = -5771184397627263588L;
	private final String jwtToken;
	
	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	

	
}
