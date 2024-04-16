package com.example.pr2.dao;

import com.example.pr2.Repository.PostRepository;
import com.example.pr2.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDAO {
    private final PostRepository postRepository;

    @Autowired
    public PostDAO(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<Post> index() {
        return postRepository.findAll();
    }
    public Post show(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public void save(Post post) {
        postRepository.save(post);
    }
    public void update(int id, Post updatedPost) {
        Post postToBeUpdated = show(id);
        if (postToBeUpdated != null) {
            postToBeUpdated.setName(updatedPost.getName());
            postToBeUpdated.setDescription(updatedPost.getDescription());
            postToBeUpdated.setSalary(updatedPost.getSalary());
            postRepository.save(updatedPost);
        }
    }
    public void delete(int id) {
        postRepository.deleteById(id);
    }
}