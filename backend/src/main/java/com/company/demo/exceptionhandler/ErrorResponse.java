package com.company.demo.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse
{
    private Long statusCode;
    private HttpStatus status;
    private LocalDateTime timeStamp;
    private String message;
    private String cause;
}
