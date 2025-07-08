package com.sathyavani.circuitbreaker.service;


import com.sathyavani.circuitbreaker.model.Message;
import com.sathyavani.circuitbreaker.repository.MessageRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @Autowired
    private MessageRepository repository;

    @KafkaListener(topics = "messages", groupId = "group_id", containerFactory = "kafkaListenerContainerFactory")
    public void consume(Message message) {
        repository.save(message);
    }

}
