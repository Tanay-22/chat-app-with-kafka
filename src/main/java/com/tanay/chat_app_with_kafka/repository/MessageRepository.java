package com.tanay.chat_app_with_kafka.repository;

import com.tanay.chat_app_with_kafka.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>
{
}
