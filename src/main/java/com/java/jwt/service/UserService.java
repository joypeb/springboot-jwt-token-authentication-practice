package com.java.jwt.service;

import com.java.jwt.domain.User;
import com.java.jwt.domain.UserRole;
import com.java.jwt.domain.dto.UserJoinRequest;
import com.java.jwt.exception.AppException;
import com.java.jwt.exception.ErrorCode;
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
                user -> new AppException(ErrorCode.DUPLICATE_USER_NAME, String.format("%s가 중복입니다",userName)));

        User user = UserJoinRequest.toEntity(userName,password,UserRole.USER);
        User userResult = userRepository.save(user);

        if(userResult.getUserName() == null)
            new AppException(ErrorCode.BAD_DATABASE_SERVER, "DB서버에 에러가 발생했습니다");

        return "Success";
    }
}
