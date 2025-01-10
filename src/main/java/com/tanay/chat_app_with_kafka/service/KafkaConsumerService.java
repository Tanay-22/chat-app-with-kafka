package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.config.Constants;
import com.tanay.chat_app_with_kafka.model.Message;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class KafkaConsumerService
{
    @KafkaListener(topics = TOPIC, groupId = Constants.GROUP)
    public void listen(@Payload Message message, @Header(KafkaHeaders.RECEIVED_KEY) String key)
    {
        Long chatId = Long.parseLong(key);
        System.out.println("Recieved Message for chatId: " + chatId + " -> " + message.getContent());
    }
}
