package ru.netology.daohibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "persons" ,schema = "netology")
public class Person {

    @EmbeddedId
    private PersonID personID;
    private Long phone;
    @Column(name = "city_of_living", table = "persons")
    private String city;
}