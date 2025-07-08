package com.sathyavani.circuitbreaker.repository;

import com.sathyavani.circuitbreaker.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {}

