package com.isakayabasi.maintermproject.repository;

import com.isakayabasi.maintermproject.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> {

}