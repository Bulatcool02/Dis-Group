package com.test.task.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class MasterExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = MasterException.class)
    public ResponseEntity<Object> handleException(MasterException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getHttpStatus());
        errorResponse.setErrorCode(ex.getErrorCode());
        return new ResponseEntity<>(errorResponse, ex.getHttpStatus());
    }
}
