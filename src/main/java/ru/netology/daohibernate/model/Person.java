package ru.netology.daohibernate.model;

import jakarta.persistence.Column;
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
    @Column (name = "phone_number")
    private Long phone_number;
    @Column (name = "city_of_living")
    private String city_of_living;
}