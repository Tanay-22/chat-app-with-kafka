package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.dto.request.CreateUserRequest;
import com.tanay.chat_app_with_kafka.model.User;
import com.tanay.chat_app_with_kafka.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserRequest req) throws Exception
    {
        User user = new User();
        user.setName(req.getName());
        user.setPhone(req.getPhone());

        return userRepository.save(user);
    }

    @Override
    public User findUserById(Long userId) throws Exception
    {
        return userRepository.findById(userId)
                .orElseThrow(() -> new Exception("User not found"));
    }
}
