package com.example.IMDB.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseBody<T> {
  private String code;
  private T message;

  public ErrorResponseBody(String code, T message) {
    this.code = code;
    this.message = message;
  }
}
