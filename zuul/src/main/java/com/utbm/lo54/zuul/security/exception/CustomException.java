package com.utbm.lo54.zuul.security.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends Throwable {
    public CustomException(String invalid_jwt_token, HttpStatus unauthorized) {
    }
}
