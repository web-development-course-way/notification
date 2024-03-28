package com.teamc.notification.exception;

import com.teamc.notification.enums.ErrorCode;
import lombok.Getter;

public class UnauthorizedException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;


    public UnauthorizedException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

}
