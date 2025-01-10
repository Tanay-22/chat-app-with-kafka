package com.tanay.chat_app_with_kafka.repository;

import com.tanay.chat_app_with_kafka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
    Optional<User> findByName(String name);


}
