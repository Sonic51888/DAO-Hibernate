package ru.netology.daohibernate.repository;


import ru.netology.daohibernate.model.Person;

import java.util.List;

public interface PersonRepository {
    public List<Person> getPersonsByCity(String city);
}