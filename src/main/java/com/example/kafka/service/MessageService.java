package com.example.kafka.service;

import com.example.kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    private KafkaProducer kafkaProducer;

    public void sendMessage(String content) {
        String message = String.format("Message: %s - Sent at: %s", content, LocalDateTime.now());
        kafkaProducer.sendMessage(message);
    }
}
