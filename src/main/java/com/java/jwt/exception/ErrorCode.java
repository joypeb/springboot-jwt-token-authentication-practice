package com.java.jwt.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    DUPLICATE_USER_NAME(HttpStatus.CONFLICT, "유저가 중복입니다"),
    USERNAME_NOT_FOUND(HttpStatus.NOT_FOUND, "유저를 찾을 수 없습니다"),
    PASSWORD_INVALID(HttpStatus.BAD_REQUEST, "패스워드가 틀렸습니다"),
    BAD_DATABASE_SERVER(HttpStatus.BAD_GATEWAY, "DB 서버에 에러가 발생했습니다");

    HttpStatus httpStatus;
    String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
