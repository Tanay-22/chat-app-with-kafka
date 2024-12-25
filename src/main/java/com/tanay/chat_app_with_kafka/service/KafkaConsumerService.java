package com.tanay.chat_app_with_kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService
{

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(String message)
    {
        System.out.println("Received Message: " + message);
    }
}