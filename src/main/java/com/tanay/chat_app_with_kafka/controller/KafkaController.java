package com.tanay.chat_app_with_kafka.controller;

import com.tanay.chat_app_with_kafka.dto.request.SendMessageRequest;
import com.tanay.chat_app_with_kafka.model.Message;
import com.tanay.chat_app_with_kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class KafkaController
{

    private final KafkaProducerService producerService;

    @Autowired
    public KafkaController(KafkaProducerService producerService)
    {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public Message sendMessage(@RequestBody SendMessageRequest req)
    {
        Message message = new Message();
        message.setSendAt(LocalDateTime.now());
        message.setId(10L);
        message.setContent(req.getContent());
        message.setSenderId(req.getSenderId());
        producerService.sendMessage(message);
        return message;
    }
}
