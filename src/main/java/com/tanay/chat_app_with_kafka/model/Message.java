package com.tanay.chat_app_with_kafka.model;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message
{
    private Long id;
    private String content;
    private LocalDateTime sendAt;
    private Long senderId;
}
