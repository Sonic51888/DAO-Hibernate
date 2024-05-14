package ru.netology.daohibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.netology.daohibernate.model.Person;

import java.util.List;


@Repository
public class PersonRepositoryImpl implements PersonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Person> getPersonsByCity(String city) {
        String query = String.format("select * from postgres.netology.persons where cityOfLiving = '%s'", city);
        var persons = entityManager.createNativeQuery(query, Person.class);
        return persons.getResultList();
    }
}