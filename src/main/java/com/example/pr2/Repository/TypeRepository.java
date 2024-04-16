package com.example.pr2.Repository;

import com.example.pr2.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    List<Type> findByNameContaining(String name);

}
