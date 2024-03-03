package com.example.IMDB.advice;

import com.example.IMDB.exception.ErrorResponseBody;
import com.example.IMDB.exception.InterruptedException;
import com.example.IMDB.exception.RequestConflictError;
import com.example.IMDB.exception.ResourceNotFoundException;
import com.example.IMDB.exception.UserNotFoundException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
@RestController
public class OrganizationExceptionHandler {
  @ResponseStatus(HttpStatus.RESET_CONTENT)
  @ExceptionHandler(RequestConflictError.class)
  public ResponseEntity<Object> RequestConflictErrorHandler(
      RequestConflictError ex, WebRequest request) {
    log.debug(
        "Resource Not Found Exception :: ApplicationErrorCode: {} | Message: {}",
        ex.getCode(),
        ex.getMessage());
    return new ResponseEntity<>(
        new ErrorResponseBody<>(ex.getCode().getCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(UserNotFoundException.class)
  public Map<String, String> handleBusinessException(UserNotFoundException ex) {
    Map<String, String> errorMap = new HashMap<>();
    errorMap.put("errorMessage", ex.getMessage());
    return errorMap;
  }

  @ExceptionHandler(value = ResourceNotFoundException.class)
  public ResponseEntity<Object> resourceNotFoundExceptionHandler(
      ResourceNotFoundException ex, WebRequest request) {
    log.debug(
        "Resource Not Found Exception :: ApplicationErrorCode: {} | Message: {}",
        ex.getCode(),
        ex.getMessage());
    return new ResponseEntity<>(
        new ErrorResponseBody<>(ex.getCode().getCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(value = InterruptedException.class)
  public ResponseEntity<Object> interruptedExceptionHandler(
      InterruptedException ex, WebRequest request) {
    log.debug(
        "Resource Not Found Exception :: ApplicationErrorCode: {} | Message: {}",
        ex.getCode(),
        ex.getMessage());
    return new ResponseEntity<>(
        new ErrorResponseBody<>(ex.getCode().getCode(), ex.getMessage()),
        HttpStatus.NOT_IMPLEMENTED);
  }
}
