package com.test.task.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
public class MasterException extends RuntimeException {
//    private static final ErrorCode DEFAULT_ERROR_CODE;
    private final Date timestamp = new Date();
    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;

    public MasterException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.httpStatus = errorCode.getHttpStatus();
    }
}
