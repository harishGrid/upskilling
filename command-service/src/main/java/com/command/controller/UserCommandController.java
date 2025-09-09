package com.command.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.command.entity.UserAccount;
import com.command.service.UserCommandService;

@RestController
@RequestMapping("/users")
public class UserCommandController {
    @Autowired
    private UserCommandService service;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserAccount user) {
        String message = service.createUser(user);
        return ResponseEntity.ok(message);
    }
}