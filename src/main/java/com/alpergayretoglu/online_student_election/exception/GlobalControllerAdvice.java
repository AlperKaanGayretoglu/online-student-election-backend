package com.alpergayretoglu.online_student_election.exception;

import com.alpergayretoglu.online_student_election.model.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<MessageResponse> handleException(EntityNotFoundException e) {
        return new ResponseEntity<>(new MessageResponse(e.getMessage(), false), e.getStatusCode());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageResponse> handleException(BadRequestException e) {
        return new ResponseEntity<>(new MessageResponse(e.getMessage(), false), e.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponse> handleException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(new MessageResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MessageResponse> handleException(Exception e) {
        return new ResponseEntity<>(new MessageResponse(e.getMessage(), false), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}