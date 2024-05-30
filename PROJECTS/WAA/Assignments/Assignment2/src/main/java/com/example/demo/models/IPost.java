package com.example.demo.models;

public interface IPost {

    long getId();

    String getTitle();

    String getContent();

    String getAuthor();

    void SetTitle(String title);

    void SetContent(String content);

    void SetAuthor(String author);

    void SetId(long id);
}
