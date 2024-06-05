package com.example.demo.models;

import java.util.List;

public interface IPost {

    long getId();

    String getTitle();

    String getContent();

    String getAuthor();

    List<Comment> getComments();

    void SetTitle(String title);

    void SetContent(String content);

    void SetAuthor(String author);

    void SetId(long id);

    void addComment(Comment comment);
}
