package com.tanay.chat_app_with_kafka.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest
{
    private String name;
    private Long phone;
}
