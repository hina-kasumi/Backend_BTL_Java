package com.hina.backend_btl_java.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<?> exceptionHandler(final RuntimeException e) {
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler(value = AppException.class)
    public ResponseEntity<?> appExceptionHandler(final AppException e) {
        return ResponseEntity.status(e.getCode()).body(e.getMessage());
    }
}
