package com.tanay.chat_app_with_kafka.controller;

import com.tanay.chat_app_with_kafka.dto.request.CreateChatRequest;
import com.tanay.chat_app_with_kafka.model.Chat;
import com.tanay.chat_app_with_kafka.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatController
{
    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService)
    {
        this.chatService = chatService;
    }

    @PostMapping("/create")
    public ResponseEntity<Chat> createChat(@RequestBody CreateChatRequest req) throws Exception
    {
        Chat chat = chatService.createChat(req);
        return new ResponseEntity<>(chat, HttpStatus.CREATED);
    }
}
