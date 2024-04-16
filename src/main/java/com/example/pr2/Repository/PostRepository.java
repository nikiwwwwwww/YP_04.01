package com.example.pr2.Repository;

import com.example.pr2.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByNameContaining(String name);

}
