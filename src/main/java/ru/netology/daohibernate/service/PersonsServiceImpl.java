package ru.netology.daohibernate.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.netology.daohibernate.model.Person;
import ru.netology.daohibernate.model.PersonID;
import ru.netology.daohibernate.repository.PersonRepository;
import ru.netology.daohibernate.repository.PersonRepositoryJPA;

import java.util.List;
import java.util.Optional;

@Service
public class PersonsServiceImpl implements PersonsService {


    private final PersonRepositoryJPA repositoryJPA;

    public PersonsServiceImpl(PersonRepository repository, PersonRepositoryJPA repositoryJPA) {
        this.repositoryJPA = repositoryJPA;
    }

    @Override
    public Person savePerson(Person person) {
        return repositoryJPA.save(person);
    }

    @Override
    public Optional<Person> findPersonById(PersonID personID) {
        return repositoryJPA.findById(personID);
    }

    @Override
    public void deletePersonByID(PersonID personID) {
        repositoryJPA.deleteById(personID);
    }

    @Override
    public List<Person> findPersonByCity(String city) {
        return repositoryJPA.findByCity(city);
    }

    @Override
    public List<Person> findByPersonID_AgeLessThan(Integer age) {
        return repositoryJPA.findByPersonID_AgeLessThan(age, Sort.by(
                new Sort.Order(Sort.Direction.ASC, "personID.age")
        ));
    }

    @Override
    public List<Optional<Person>> findByPersonID_NameAndPersonID_Surname(String name, String surname) {
        return repositoryJPA.findByPersonID_NameAndPersonID_Surname(name, surname);
    }
}