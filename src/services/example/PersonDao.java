package services.example;

import model.entities.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDao implements model.dao.PersonDao {
    @Override
    public List<Person> findAll() {
        List<Person> list = new ArrayList<>();

        Person p = new Person();
        p.setApiRest(5);
        p.setGit(5);
        p.setJava(5);
        p.setModeling(5);
        p.setName("Thomas Moura");
        p.setSpring(5);
        list.add(p);

        return list;
    }
}
