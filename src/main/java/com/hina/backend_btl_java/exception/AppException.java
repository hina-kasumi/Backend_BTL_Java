package com.hina.backend_btl_java.exception;

import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    int code;

    public AppException(int code, String message) {
        super(message);
        this.code = code;
    }


}
