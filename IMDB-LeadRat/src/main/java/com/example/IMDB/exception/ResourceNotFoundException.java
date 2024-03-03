package com.example.IMDB.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException {

  public ResourceNotFoundException(String message, ApplicationErrorCode code, HttpStatus status) {
    super(code, status, message);
  }
}
