package com.productexseption.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class SuccessfulResponse<T> {
    private ResponseMessage message;
    private HttpStatus httpStatus;
    private String messages;
    private Void aVoid;
    private T data;


    public SuccessfulResponse(T data, HttpStatus status) {
        this.data = data;
        this.httpStatus = status;
    }

    public SuccessfulResponse(String message, HttpStatus status) {
        this.messages = message;
        this.httpStatus = status;
    }

    public SuccessfulResponse(HttpStatus status) {
        this.httpStatus = status;
    }

    public SuccessfulResponse(T status) {
        this.data = status;
    }
}
