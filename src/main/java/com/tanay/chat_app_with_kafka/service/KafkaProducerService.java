package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.dto.request.SendMessageRequest;
import com.tanay.chat_app_with_kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaProducerService
{
    private final KafkaTemplate<String, Message> kafkaTemplate;
    private static final String TOPIC = "my-topic";

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Message> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public Message sendMessage(SendMessageRequest req)
    {
        Message message = new Message();
        message.setSendAt(LocalDateTime.now());
        message.setId(10L);
        message.setContent(req.getContent());
        message.setSenderId(req.getSenderId());
        kafkaTemplate.send(TOPIC, message);

        return message;
    }
}
