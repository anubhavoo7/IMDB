package com.example.IMDB.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApplicationException extends RuntimeException {
  private final ApplicationErrorCode code;
  private final HttpStatus status;
  private final String message;

  public ApplicationException(ApplicationErrorCode code, HttpStatus status, String message) {
    this.code = code;
    this.status = status;
    this.message = message;
  }
}
