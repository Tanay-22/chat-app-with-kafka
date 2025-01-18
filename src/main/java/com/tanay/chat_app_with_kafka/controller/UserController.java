package com.tanay.chat_app_with_kafka.controller;

import com.tanay.chat_app_with_kafka.dto.request.CreateUserRequest;
import com.tanay.chat_app_with_kafka.model.User;
import com.tanay.chat_app_with_kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest req) throws Exception
    {
        User user = userService.createUser(req);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
