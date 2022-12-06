package com.naidiuk.restpractice.web.controller.handler;

import com.naidiuk.restpractice.error.GroupNotFoundException;
import com.naidiuk.restpractice.error.TeacherNotFoundException;
import com.naidiuk.restpractice.web.controller.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({
            TeacherNotFoundException.class,
            GroupNotFoundException.class
    })
    public ResponseEntity<?> handle(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage()));
    }
}
