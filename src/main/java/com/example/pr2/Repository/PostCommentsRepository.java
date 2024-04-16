package com.example.pr2.Repository;

import com.example.pr2.models.PostComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentsRepository extends JpaRepository<PostComments, Integer> {


}