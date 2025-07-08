package com.sathyavani.circuitbreaker.controller;

import com.sathyavani.circuitbreaker.service.KafkaProducerService;
import com.sathyavani.circuitbreaker.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping
    public ResponseEntity<String> produce(@RequestBody Message message) {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka");
    }
}