package com.example.IMDB.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="movie_directors")
public class MovieDirectors {

    @Id
    @Column(name="id")
    private String movieDirectorsId;

    @ManyToOne(targetEntity = Movie.class)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movie;

    @ManyToOne(targetEntity = Director.class)
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director director;

}
