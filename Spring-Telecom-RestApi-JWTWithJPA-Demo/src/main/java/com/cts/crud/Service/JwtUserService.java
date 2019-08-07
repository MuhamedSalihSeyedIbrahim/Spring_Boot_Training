package com.cts.crud.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.crud.Dao.JwtUserDao;
import com.cts.crud.Model.JwtRequest;
import com.cts.crud.Model.JwtUser;

@Service
public class JwtUserService implements UserDetailsService {
	
	@Autowired
	private JwtUserDao dao; 
	
	@Autowired
	private PasswordEncoder bycrypt;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		JwtUser user = dao.findByUsername(username);
		
		if(user == null)
		{
			throw new UsernameNotFoundException("User not found");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}
	
	public JwtUser save(JwtRequest user)
	{
		JwtUser userDTO = new JwtUser();
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(bycrypt.encode(user.getPassword()));
		return dao.save(userDTO);
	}

}
