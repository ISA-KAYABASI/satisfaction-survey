package com.isakayabasi.maintermproject.repository;

import com.isakayabasi.maintermproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {

}