package com.example.pr2.dao;

import com.example.pr2.Repository.PersonRepository;
import com.example.pr2.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonDAO {
    private final PersonRepository personRepository;

    @Autowired
    public PersonDAO(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<Person> index() {
        return personRepository.findAll();
    }
    public Person show(int id) {
        return personRepository.findById(id).orElse(null);
    }

    public void save(Person person) {
        personRepository.save(person);
    }
    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        if (personToBeUpdated != null) {
            personToBeUpdated.setEmail(updatedPerson.getEmail());
            personToBeUpdated.setPassword(updatedPerson.getPassword());
            personToBeUpdated.setUsername(updatedPerson.getUsername());
            personRepository.save(updatedPerson);
        }
    }
    public void delete(int id) {
        personRepository.deleteById(id);
    }
}