package com.cts.crud.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.crud.Model.PrepaidOffers;

@Repository
public interface PrePaidDao extends JpaRepository<PrepaidOffers, Long>  {

}
