package com.spring.task.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(final RuntimeException e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<String> handleDogsServiceException(final ApiException e){
        return error(INTERNAL_SERVER_ERROR, e);
    }

    private ResponseEntity<String> error(final HttpStatus status, final Exception e) {
        log.error("Exception : ", e);
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
