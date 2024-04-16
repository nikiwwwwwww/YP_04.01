package com.example.pr2.Repository;

import com.example.pr2.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByUsernameContaining(String name);

}
