package ru.netology.daohibernate.service;

import ru.netology.daohibernate.model.Person;

import java.io.IOException;
import java.util.List;

public interface PersonsService {
    List<Person> getPersonsByCity(String city) throws IOException;

}