package com.tanay.chat_app_with_kafka.repository;

import com.tanay.chat_app_with_kafka.model.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long>
{
}
