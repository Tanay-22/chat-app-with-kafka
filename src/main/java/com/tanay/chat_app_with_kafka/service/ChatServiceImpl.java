package com.tanay.chat_app_with_kafka.service;

import com.tanay.chat_app_with_kafka.dto.request.CreateChatRequest;
import com.tanay.chat_app_with_kafka.model.Chat;
import com.tanay.chat_app_with_kafka.model.User;
import com.tanay.chat_app_with_kafka.repository.ChatRepository;
import com.tanay.chat_app_with_kafka.repository.UserRepository;


public class ChatServiceImpl implements ChatService
{
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public ChatServiceImpl(ChatRepository chatRepository, UserRepository userRepository)
    {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Chat createChat(CreateChatRequest req) throws Exception
    {
        Chat chat = new Chat();
        chat.setName(req.getName());

        for(Long userId: req.getUserIds())
        {
            User user = userRepository.findById(userId)
                    .orElseThrow(()-> new Exception("User with id - " + userId + " not found"));
            chat.getUsers().add(user);
        }
        return chatRepository.save(chat);
    }
}
