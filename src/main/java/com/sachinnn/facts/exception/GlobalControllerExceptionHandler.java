package com.sachinnn.facts.exception;

import com.sachinnn.facts.model.dto.CommonException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.persistence.PersistenceException;
import java.util.Date;

/**
 * <h1>GlobalControllerExceptionHandler</h1>
 * @author sachinnn
 * @since 16.06.2022
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonException> ExceptionHandler(RuntimeException ex) {
        return new ResponseEntity<>(
                new CommonException(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(), new Date()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ConversionFailedException.class)
    public ResponseEntity<CommonException> handleConflict(RuntimeException ex) {
        return new ResponseEntity<>(
                new CommonException(HttpStatus.BAD_REQUEST.value(),ex.getMessage(), new Date()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpClientErrorException.class, HttpServerErrorException.class})
    public ResponseEntity<CommonException> httpCallErrors(RuntimeException ex) {
        return new ResponseEntity<>(
                new CommonException(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(), new Date()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<CommonException> unAuthorized(Exception ex) {
        return new ResponseEntity<>(
                new CommonException(HttpStatus.UNAUTHORIZED.value(),ex.getMessage(), new Date()),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(PersistenceException.class)
    public ResponseEntity<CommonException> persistenceException(Exception ex) {
        return new ResponseEntity<>(
                new CommonException(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage(), new Date()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
