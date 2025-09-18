package com.example.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);
    private static final String TOPIC_NAME = "my-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info("Sending message: {}", message);
        
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC_NAME, message);
        
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info("Message sent successfully: {}", result.getRecordMetadata().offset());
            } else {
                logger.error("Failed to send message", ex);
            }
        });
    }
}
