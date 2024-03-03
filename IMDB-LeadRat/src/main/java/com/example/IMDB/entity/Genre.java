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
@Table(name = "genre")
public class Genre {

    @Id
    @Column(name="genre_id")
    private String genreId;

    @Column(name = "genre_name")
    private String genreName;
    @Column(name="created_dttm")
    private ZonedDateTime createdDttm;



    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_active")
    private Boolean isActive = true;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_deleted")
    private Boolean deleted = false;

}
