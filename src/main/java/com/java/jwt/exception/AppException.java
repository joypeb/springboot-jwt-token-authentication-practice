package com.java.jwt.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AppException extends Throwable {

    private ErrorCode errorCode;
    private String message;
}
