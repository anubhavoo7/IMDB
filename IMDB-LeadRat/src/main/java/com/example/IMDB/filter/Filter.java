package com.example.IMDB.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filter {

  private String attribute;
  private String operator;
  private String value;
  private String dataType;
}
