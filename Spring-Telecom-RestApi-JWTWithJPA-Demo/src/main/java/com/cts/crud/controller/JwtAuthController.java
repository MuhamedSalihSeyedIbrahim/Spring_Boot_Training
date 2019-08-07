package com.cts.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crud.Model.JwtRequest;
import com.cts.crud.Model.JwtResponse;
import com.cts.crud.Model.JwtUser;
import com.cts.crud.Service.JwtUserService;
import com.cts.crud.config.JwtTokenUtil;

@RestController
@CrossOrigin
public class JwtAuthController {
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private JwtUserService detailsService;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authenticationRequest) throws Exception
	{
		authenticate(authenticationRequest.getUsername(), 
				authenticationRequest.getPassword());
		
		final UserDetails userDetails = detailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	
	public void authenticate(String name,String pass) throws Exception
	{
		try
		{
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(name, pass));
			
		}catch(DisabledException e)
		{
			throw new Exception("User disable",e);
		}
		catch(BadCredentialsException e)
		{
			throw new Exception("Invalid disable",e);
		}
	}
	
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ResponseEntity<JwtUser> saveUser(@RequestBody JwtRequest user) throws Exception{
		return ResponseEntity.ok(detailsService.save(user));
	}
}
