package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.dto.request.SendMessageRequest;
import com.tanay.chat_app_with_kafka.model.Chat;
import com.tanay.chat_app_with_kafka.model.Message;
import com.tanay.chat_app_with_kafka.model.User;
import com.tanay.chat_app_with_kafka.repository.ChatRepository;
import com.tanay.chat_app_with_kafka.repository.MessageRepository;
import com.tanay.chat_app_with_kafka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.springframework.kafka.support.KafkaHeaders.TOPIC;

@Service
public class KafkaProducerService
{
    private final KafkaTemplate<String, Message> kafkaTemplate;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Message> kafkaTemplate, UserRepository userRepository,
                                MessageRepository messageRepository, ChatRepository chatRepository)
    {
        this.kafkaTemplate = kafkaTemplate;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
    }


    public Message sendMessage(SendMessageRequest req) throws Exception
    {
        User sender = userRepository.findById(req.getSenderId())
                .orElseThrow(() -> new Exception("Sender not found"));

        Chat chat = chatRepository.findById(req.getChatId())
                .orElseThrow(() -> new Exception("Chat not found"));

        Message message = new Message();
        message.setSendAt(LocalDateTime.now());
        message.setId(10L);
        message.setContent(req.getContent());
        message.setSender(sender);
        message.setChat(chat);
        kafkaTemplate.send(TOPIC, req.getChatId().toString(), message);

        return messageRepository.save(message);
    }
}
