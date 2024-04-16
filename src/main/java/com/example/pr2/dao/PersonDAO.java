package com.example.pr2.dao;

import com.example.pr2.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", "tom@example.com", "password1"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", "bob@example.com", "password2"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", "mike@example.com", "password3"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(people.size()+1);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        if (personToBeUpdated != null) {
            personToBeUpdated.setUsername(updatedPerson.getUsername());
            personToBeUpdated.setEmail(updatedPerson.getEmail());
            personToBeUpdated.setPassword(updatedPerson.getPassword());
        }
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}