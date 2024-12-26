package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

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

    public void sendMessage(Message message)
    {
        kafkaTemplate.send(TOPIC, message);
    }
}
