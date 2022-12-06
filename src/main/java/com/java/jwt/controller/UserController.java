package com.java.jwt.controller;

import com.java.jwt.domain.dto.UserJoinRequest;
import com.java.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinRequest userJoinRequest) {
        String result = userService.join(userJoinRequest.getUserName(), userJoinRequest.getUserName());
        return ResponseEntity.ok().body(result);
    }
}
