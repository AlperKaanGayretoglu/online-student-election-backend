package com.alpergayretoglu.online_student_election.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class BadRequestException extends RuntimeException {

    private final HttpStatus statusCode = HttpStatus.BAD_REQUEST;
    private String message = "The request has been rejected";

    public BadRequestException(String message) {
        this.message = message;
    }

}
