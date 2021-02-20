package com.smarthost.room.domain.exceptions;

public class ApiException extends RuntimeException {

    public final ApiExceptionType type;
    public final String message;

    public ApiException(ApiExceptionType type, String message) {
        super(message);
        this.type = type;
        this.message = message;
    }

    public enum ApiExceptionType {

        NOT_FOUND,
        INTERNAL_SERVER_ERROR,
        BAD_REQUEST

    }

}
