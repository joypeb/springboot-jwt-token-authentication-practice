package com.java.jwt.controller;

import com.java.jwt.domain.dto.UserJoinRequest;
import com.java.jwt.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody UserJoinRequest userJoinRequest) {
        log.info("POST /api/v1/users/join RequestBody : " + userJoinRequest.toString());
        String result = userService.join(userJoinRequest.getUserName(), userJoinRequest.getUserName());
        return ResponseEntity.ok().body(result);
    }
}
