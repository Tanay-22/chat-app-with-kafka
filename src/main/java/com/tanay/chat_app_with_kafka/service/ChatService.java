package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.dto.request.CreateChatRequest;
import com.tanay.chat_app_with_kafka.model.Chat;

public interface ChatService
{
    Chat createChat(CreateChatRequest req) throws Exception;
}
