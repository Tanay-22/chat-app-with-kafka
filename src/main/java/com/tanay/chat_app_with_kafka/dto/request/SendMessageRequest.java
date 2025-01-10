package com.tanay.chat_app_with_kafka.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SendMessageRequest
{
    private String content;
    private Long senderId;
    private Long chatId;
}