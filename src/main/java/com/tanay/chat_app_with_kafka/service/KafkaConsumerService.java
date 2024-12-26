package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.model.Message;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class KafkaConsumerService
{
    private final RestTemplate restTemplate;

    @Getter
    private final Queue<Message> messageQueue = new ConcurrentLinkedQueue<>();

    @Autowired
    public KafkaConsumerService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    public void listen(Message message)
    {
        System.out.println("Received Message: " + message);
        messageQueue.offer(message);
    }

}
