package com.teamc.notification.exception;

import com.teamc.notification.enums.ErrorCode;
import lombok.Getter;

public class ValidationException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;


    public ValidationException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

}
