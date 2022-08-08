package com.isakayabasi.maintermproject.repository;

import com.isakayabasi.maintermproject.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends JpaRepository<Result, Long> {

    Result findByEmail(String email);
	
}
