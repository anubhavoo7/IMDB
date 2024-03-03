package com.example.IMDB.exception;

import org.springframework.http.HttpStatus;

public class RequestConflictError extends ApplicationException {
  public RequestConflictError(String message, ApplicationErrorCode code, HttpStatus status) {
    super(code, status, message);
  }
}
