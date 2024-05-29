package com.example.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post implements IPost {

    private long id;
    private String title;
    private String content;
    private String author;

    @Override
    public long getId() {
        return id;
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
