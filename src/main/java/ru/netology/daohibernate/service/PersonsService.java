package ru.netology.daohibernate.service;

import ru.netology.daohibernate.model.Person;
import ru.netology.daohibernate.model.PersonID;

import java.util.List;
import java.util.Optional;

public interface PersonsService {

    public Person savePerson(Person person);

    public Optional<Person> findPersonById(PersonID personID);

    public void deletePersonByID(PersonID personID);

    public List<Person> findPersonByCity(String city);

    public List<Person> findByPersonID_AgeLessThan(Integer age);

    public List<Optional<Person>> findByPersonID_NameAndPersonID_Surname(String name, String surname);
}