package com.example.pr2.dao;

import com.example.pr2.models.Post;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class PostDAO {
    private static int POSTS_COUNT;
    private final List<Post> posts;

    {
        posts = new ArrayList<>();

        posts.add(new Post(++POSTS_COUNT, "Post1", "Description1", 1000.0));
        posts.add(new Post(++POSTS_COUNT, "Post2", "Description2", 1500.0));
        posts.add(new Post(++POSTS_COUNT, "Post3", "Description3", 2000.0));
    }

    public List<Post> index() {
        return posts;
    }

    public Post show(int id) {
        return posts.stream().filter(post -> post.getId() == id).findAny().orElse(null);
    }

    public void save(Post post) {
        post.setId(++POSTS_COUNT);
        posts.add(post);
    }

    public void update(int id, Post updatedPost) {
        Post postToBeUpdated = show(id);

        if (postToBeUpdated != null) {
            postToBeUpdated.setName(updatedPost.getName());
            postToBeUpdated.setDescription(updatedPost.getDescription());
            postToBeUpdated.setSalary(updatedPost.getSalary());
        }
    }

    public void delete(int id) {
        posts.removeIf(p -> p.getId() == id);
    }
}
