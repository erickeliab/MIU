package com.example.demo.models.dto.response;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;
import org.modelmapper.internal.bytebuddy.asm.Advice;

@Data
public class PostDto {
    private long id;
    private String title;
    private String content;

    private String author;
}