package com.cts.crud.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.crud.Model.JwtUser;

@Repository
public interface JwtUserDao extends JpaRepository<JwtUser, Long> {
	
	JwtUser findByUsername(String name);
}
