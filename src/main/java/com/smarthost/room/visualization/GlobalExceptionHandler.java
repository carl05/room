package com.smarthost.room.visualization;


import com.smarthost.room.domain.exceptions.ApiException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Order(Ordered.HIGHEST_PRECEDENCE)
public @RestControllerAdvice
class GlobalExceptionHandler {

    public @ExceptionHandler(Exception.class)
    ResponseEntity<ApiExceptionResponse> handleGenericException(Exception e) {
        var response = new ApiExceptionResponse(ApiException.ApiExceptionType.INTERNAL_SERVER_ERROR.toString(), e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }


    public @ExceptionHandler(ApiException.class)
    ResponseEntity<ApiExceptionResponse> handleApiException(ApiException e) {
        var response = new ApiExceptionResponse(e.type.toString(), e.message);
        if (e.type.equals(ApiException.ApiExceptionType.NOT_FOUND)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(response);
        }

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }


    private class ApiExceptionResponse {
        public final String type;
        public final String message;

        public ApiExceptionResponse(String type, String message1) {
            this.type = type;
            this.message = message1;
        }
    }

}
