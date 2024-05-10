package ru.netology.daohibernate.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "persons")
public class Person {

    @EmbeddedId
    private PersonID id;
    private Long phone_number;
    private String city_of_living;
}