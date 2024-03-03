package com.example.IMDB.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Setter
@Getter
@Table(name="actor")
public class Actor {

    @Id
    @Column(name="actor_id")
    private String actorId;

    @Column(name="movie_id")
    private String movieId;

    @Column(name="actor_name")
    private String actorName;

    @Column(name="created_dttm")
    private ZonedDateTime createdDttm;


    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_active")
    private Boolean isActive = true;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_deleted")
    private Boolean deleted = false;



}
