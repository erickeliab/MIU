package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post implements IPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;
    private String author;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void SetId(long id) {
        this.id = id;
    }

    @Override
    public void addComment(Comment comment) {
        comments.add(comment);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public void SetTitle(String title) {
        this.title = title;
    }

    @Override
    public void SetContent(String content) {
        this.content = content;
    }

    @Override
    public void SetAuthor(String author) {
        this.author = author;
    }


}
