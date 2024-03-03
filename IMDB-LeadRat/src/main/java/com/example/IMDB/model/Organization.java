package com.example.IMDB.model;

import com.example.IMDB.entity.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization {
  private Movie movie;
  private Actor actor;
  private Director director;
  private Genre genre;
  private Review review;
}
