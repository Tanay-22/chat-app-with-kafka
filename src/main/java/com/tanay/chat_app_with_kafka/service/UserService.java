package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.dto.request.CreateUserRequest;
import com.tanay.chat_app_with_kafka.model.User;

public interface UserService
{
    User createUser(CreateUserRequest req) throws Exception;

    User findUserById(Long userId) throws Exception;

}
