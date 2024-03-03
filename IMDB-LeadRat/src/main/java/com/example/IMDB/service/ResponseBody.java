package com.example.IMDB.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseBody<T> {
  private HttpStatus status;
  private T payload;

  public ResponseBody(HttpStatus status, T payload) {
    this.status = status;
    this.payload = payload;
  }
}
