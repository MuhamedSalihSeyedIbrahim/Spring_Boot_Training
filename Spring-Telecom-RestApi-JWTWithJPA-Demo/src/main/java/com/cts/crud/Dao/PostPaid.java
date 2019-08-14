package com.cts.crud.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.crud.Model.Postpaid;


@Repository
public interface PostPaid extends  JpaRepository<Postpaid, Long>  {

}
