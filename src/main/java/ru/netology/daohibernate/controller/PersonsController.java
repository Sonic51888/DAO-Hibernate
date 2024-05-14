package ru.netology.daohibernate.controller;

import org.springframework.web.bind.annotation.*;
import ru.netology.daohibernate.model.Person;
import ru.netology.daohibernate.model.PersonID;
import ru.netology.daohibernate.service.PersonsServiceImpl;

import java.util.List;
import java.util.Optional;


@RestController
public class PersonsController {
    private final PersonsServiceImpl personsService;

    public PersonsController(PersonsServiceImpl personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/persons/save")
    public Person savePerson(@RequestBody Person person) {
        return personsService.savePerson(person);
    }

    @GetMapping("/persons/find-by-id")
    public Optional<Person> findPersonById(@RequestBody PersonID personID) {
        return personsService.findPersonById(personID);
    }

    @GetMapping("/persons/delete-by-id")
    public void deletePersonByID(@RequestBody PersonID personID) {
        personsService.deletePersonByID(personID);
    }

    @GetMapping("/persons/find-by-city")
    public List<Person> findByCityOfLiving(@RequestParam String city) {
        List<Person> persons = personsService.findPersonByCity(city);
        persons.forEach(System.out::println);
        return personsService.findPersonByCity(city);
    }

    @GetMapping("/persons/find-by-age-less-than")
    public List<Person> findByCityOfLiving(@RequestParam Integer age) {
        return personsService.findByPersonID_AgeLessThan(age);
    }

    @GetMapping("/persons/find-by-name-surname")
    public List<Optional<Person>> findByPersonID_NameAndPersonID_Surname(@RequestParam String name, String surname) {
        return personsService.findByPersonID_NameAndPersonID_Surname(name, surname);
    }


}