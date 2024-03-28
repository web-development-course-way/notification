package com.teamc.notification.advice;


import com.teamc.notification.dto.ErrorResDto;
import com.teamc.notification.exception.NotFoundException;
import com.teamc.notification.exception.UnauthorizedException;
import com.teamc.notification.exception.ValidationException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@Slf4j
public class GeneralControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<ErrorResDto> handleValidationException(ValidationException ex) {
        log.info("Validation Error: " + ex.getErrorCode().getCode());
        ex.printStackTrace();
        return new ResponseEntity<>(ErrorResDto.builder().errorCode(ex.getErrorCode().getCode()).build(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<ErrorResDto> handleNotFoundException(NotFoundException ex) {
        log.info("Not Found Error: " + ex.getErrorCode().getCode());
        ex.printStackTrace();
        return new ResponseEntity<>(ErrorResDto.builder().errorCode(ex.getErrorCode().getCode()).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    ResponseEntity<ErrorResDto> handleUnauthorizedException(UnauthorizedException ex) {
        log.info("User Unauthorized: " + ex.getErrorCode().getCode());
        ex.printStackTrace();
        return new ResponseEntity<>(ErrorResDto.builder().errorCode(ex.getErrorCode().getCode()).build(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ErrorResDto> handleValidationException(ConstraintViolationException ex) {
        log.info("Validation Error: " + ex.getMessage());
        ex.printStackTrace();
        return new ResponseEntity<>(ErrorResDto.builder().errorCode(ex.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }

}
