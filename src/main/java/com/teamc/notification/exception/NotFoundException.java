package com.teamc.notification.exception;

import com.teamc.notification.enums.ErrorCode;
import lombok.Getter;

public class NotFoundException extends RuntimeException {

    @Getter
    private final ErrorCode errorCode;


    public NotFoundException(ErrorCode errorCode) {
        super();
        this.errorCode = errorCode;
    }

}
