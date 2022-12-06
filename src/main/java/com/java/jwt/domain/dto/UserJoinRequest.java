package com.java.jwt.domain.dto;

import com.java.jwt.domain.User;
import com.java.jwt.domain.UserRole;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserJoinRequest {
    private String userName;
    private String password;

    public static User toEntity(String userName, String password, UserRole userRole) {
        return User.builder()
                .userName(userName)
                .password(password)
                .userRole(userRole)
                .build();
    }
}
