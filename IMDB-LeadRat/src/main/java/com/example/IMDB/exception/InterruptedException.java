package com.example.IMDB.exception;

import org.springframework.http.HttpStatus;

public class InterruptedException extends ApplicationException {

  public InterruptedException(ApplicationErrorCode code, HttpStatus status, String message) {
    super(code, status, message);
  }
}
