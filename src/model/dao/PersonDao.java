package model.dao;

import model.entities.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAll();
}
