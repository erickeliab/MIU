package com.example.demo.controllers;
import com.example.demo.models.Comment;
import com.example.demo.models.Post;
import com.example.demo.models.dto.response.CommentDto;
import com.example.demo.services.CommentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getAll(){
        return commentService.getAll();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CommentDto getById(@PathVariable long id){
        return commentService.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Comment c){
        commentService.save(c);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Comment update(@RequestBody Comment c, @PathVariable("id") long id){
        return commentService.update(id,c);
    }


    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable("id") long id){
        commentService.delete(id);
    }

}
