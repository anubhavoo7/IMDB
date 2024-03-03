package com.example.IMDB.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@Table(name = "movie")
//@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Movie {
  @Id
  @Column(name = "movie_id")
  private String movieId;

  @Column(name = "title")
  private String movieTitle;


  @Column(name = "release_date")
  private String releaseDate;

  @Column(name = "release_country")
  private String releaseCountry;

  @Type(type = "org.hibernate.type.NumericBooleanType")
  @Column(name = "is_active")
  private Boolean isActive = true;

  @Type(type = "org.hibernate.type.NumericBooleanType")
  @Column(name = "is_deleted")
  private Boolean deleted = false;

  @Column(name="created_dttm")
  private ZonedDateTime createdDttm;
}
