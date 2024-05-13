package ru.netology.daohibernate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daohibernate.model.Person;
import ru.netology.daohibernate.service.PersonsServiceImpl;

import java.io.IOException;
import java.util.List;

@RestController
public class PersonsController {
    private final PersonsServiceImpl personsService;

    public PersonsController(PersonsServiceImpl personsService) {
        this.personsService = personsService;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) throws IOException {
        return personsService.getPersonsByCity(city);
    }
}