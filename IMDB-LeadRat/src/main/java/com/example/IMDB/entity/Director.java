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
@Getter
@Setter
@Table(name="director")
public class Director {

    @Id
    @Column(name="director_id")
    private String directorId;

    @Column(name = "director_name")
    private String directorName;
    @Column(name="created_dttm")
    private ZonedDateTime createdDttm;



    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_active")
    private Boolean isActive = true;

    @Type(type = "org.hibernate.type.NumericBooleanType")
    @Column(name = "is_deleted")
    private Boolean deleted = false;


}
