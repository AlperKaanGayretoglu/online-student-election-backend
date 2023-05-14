package com.alpergayretoglu.online_student_election.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@NoArgsConstructor
public class EntityNotFoundException extends RuntimeException {

    private final HttpStatus statusCode = HttpStatus.NOT_FOUND;
    private String message = "Entity with given credentials was not found";

    public EntityNotFoundException(String message) {
        this.message = message;
    }

}
