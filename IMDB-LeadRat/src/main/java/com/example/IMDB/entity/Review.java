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
@Table(name="review")
public class Review {

    @Id
    @Column(name = "review_id")
    private String reviewId;

    @Column(name="movie_id")
    private String movieId;

    @Column(name="reviewer_name")
    private String reviewerName;

    @Column(name="reviewer_rating")
    private double reviewerRating;

    @Column(name="review")
    private String review;

    @Column(name="created_dttm")
    private ZonedDateTime createdDttm;


    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_active")
    private Boolean isActive = true;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_deleted")
    private Boolean deleted = false;



}
