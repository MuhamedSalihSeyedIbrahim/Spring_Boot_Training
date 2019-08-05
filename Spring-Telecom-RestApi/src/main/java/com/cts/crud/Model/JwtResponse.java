package com.cts.crud.Model;

import java.io.Serializable;

public class JwtResponse implements Serializable {
	
	private static final long serialVersionUID= -4734973473489793487L;
	private final String token;
	
		
	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getJwtToken() {
		return token;
	}
	

}
