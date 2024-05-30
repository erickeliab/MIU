package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements IUser{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String name;

    @OneToMany
    @JoinColumn(name = "user_id") // Foreign key column in Post table
    private List<Post> posts = new ArrayList<>();

    @Override
    public long getId() {
        return Id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setId(long id) {
        this.Id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }
}
