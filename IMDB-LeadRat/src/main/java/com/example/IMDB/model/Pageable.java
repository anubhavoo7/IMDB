package com.example.IMDB.model;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pageable implements Serializable {
  @Serial
  private static final long serialVersionUID = 5784755658375539810L;

  private long pageNo;

  private long pageSize;

  private long pages;

  private long size;
}
