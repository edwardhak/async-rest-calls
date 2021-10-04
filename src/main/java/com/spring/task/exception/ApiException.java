package com.spring.task.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApiException extends Exception {

    private HttpStatus status;
    private String message;
}
