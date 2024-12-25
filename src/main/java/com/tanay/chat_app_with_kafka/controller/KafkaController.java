package com.tanay.chat_app_with_kafka.controller;

import com.tanay.chat_app_with_kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController
{

    private final KafkaProducerService producerService;

    @Autowired
    public KafkaController(KafkaProducerService producerService)
    {
        this.producerService = producerService;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String message)
    {
        producerService.sendMessage("my-topic", message);
        return "Message sent successfully";
    }
}
