package com.example.IMDB.exception;

public enum ApplicationErrorCode {
  RESOURCE_NOT_FOUND("ResourceNotFound"),
  RESULTS_NOT_FOUND("ResultsNotFound"),
  RESOURCE_CONFLICT("ResourceConflict");
  private final String code;

  private ApplicationErrorCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }
}
