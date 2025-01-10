package com.tanay.chat_app_with_kafka.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateChatRequest
{
    private String name;
    private List<Long> userIds;
}
