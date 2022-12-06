package com.java.jwt.service;

import com.java.jwt.domain.User;
import com.java.jwt.domain.UserRole;
import com.java.jwt.domain.dto.UserJoinRequest;
import com.java.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    public String join(String userName, String password) {
        userRepository.findByUserName(userName).ifPresent(
                user -> {throw new RuntimeException(String.format("%s가 이미 존재합니다", userName));
                });

        User user = UserJoinRequest.toEntity(userName,password,UserRole.USER);
        User userResult = userRepository.save(user);

        if(userResult.getUserName() == null)
            throw new RuntimeException(String.format("회원가입에 실패하였습니다"));

        return "Success";
    }
}
