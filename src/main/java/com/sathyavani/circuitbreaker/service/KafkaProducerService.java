package com.sathyavani.circuitbreaker.service;

import com.sathyavani.circuitbreaker.model.Message;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @Retry(name = "kafkaService")
    @CircuitBreaker(name = "kafkaService", fallbackMethod = "fallbackSend")
    public void sendMessage(Message message) {
        kafkaTemplate.send("messages", message);
    }

    public void fallbackSend(Message message, Throwable t) {
        System.out.println("Fallback invoked for message: " + message.getContent());
    }
}