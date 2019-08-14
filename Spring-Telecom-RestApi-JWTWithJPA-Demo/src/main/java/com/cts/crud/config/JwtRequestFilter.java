package com.cts.crud.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties.Chain;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.cts.crud.Service.JwtUserService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUserService JwtUserDetailsService;
	
	@Autowired
	private JwtTokenUtil JwtTokenUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestTokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwttoken = null;
		
		if(requestTokenHeader !=null && requestTokenHeader.startsWith("Ashwin ")) {
			jwttoken = requestTokenHeader.substring(7);
			try
			{
				username = JwtTokenUtil.getUsernameFromToken(jwttoken);
			}catch(IllegalArgumentException e)
			{
				System.out.println("Unable to get JWT Token");
			}catch(ExpiredJwtException e)
			{
				System.out.println("JWT Toekn has expired");
			}
		}
		else
		{
			logger.warn("JWT token does not begin with Ashwin String");
		}
		
		if(username !=null && SecurityContextHolder.getContext().getAuthentication() == null)
		{
			UserDetails details = this.JwtUserDetailsService.loadUserByUsername(username);
			if(JwtTokenUtil.validateToken(jwttoken, details))
			{
				UsernamePasswordAuthenticationToken authenticationToken = 
						new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}

}
