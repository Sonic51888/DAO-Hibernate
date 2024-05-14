package ru.netology.daohibernate.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.daohibernate.model.Person;
import ru.netology.daohibernate.model.PersonID;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepositoryJPA extends JpaRepository<Person, PersonID> {
    List<Person> findByCity(String city);

    List<Person> findByPersonID_AgeLessThan(Integer age, Sort sort);

    List<Optional<Person>> findByPersonID_NameAndPersonID_Surname(String name, String surname);
}

