package com.github.youssfbr.todolist.controllers.exceptions;

import com.github.youssfbr.todolist.services.exceptions.UsernameExistsException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<StandardError> UsernameExistsException (
            UsernameExistsException e,
            HttpServletRequest request)
    {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        StandardError error = StandardError.builder()
                .timestamp(Instant.now())
                .status(status.value())
                .error("Nome de usuário já existente.")
                .message(e.getMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(error, status);
    }

}
