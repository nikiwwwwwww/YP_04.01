package com.example.pr2.Repository;


import com.example.pr2.models.modelUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<modelUser,Long> {
    modelUser findByUsername(String username);
}