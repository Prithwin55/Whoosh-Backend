package com.whoosh_backend.Whoosh_Backend.data.exception.handle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorDetails {

    private String message;
    private String error;
    private LocalDateTime timestamp;
}
