package com.tanay.chat_app_with_kafka.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;
    private LocalDateTime sendAt;

    @ManyToOne
    private Chat chat;

    @ManyToOne
    private User sender;
}
