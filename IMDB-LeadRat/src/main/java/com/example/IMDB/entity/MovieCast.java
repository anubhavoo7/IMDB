package com.example.IMDB.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name="movie_cast")
public class MovieCast {

    @Id
    @Column(name="Id")
    private String movieCastId;

    @ManyToOne(targetEntity = Movie.class)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    private Movie movieId;


    @ManyToOne(targetEntity = Actor.class)
    @JoinColumn(name = "actor_id", referencedColumnName = "actor_id")
    private Actor actorId;

    @ManyToOne(targetEntity = Director.class)
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    private Director directorId;

}
