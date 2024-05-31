package com.example.demo.services;

import com.example.demo.models.Comment;
import com.example.demo.models.Post;
import com.example.demo.models.dto.response.CommentDto;
import com.example.demo.repositories.CommentRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CommentService {

    @Autowired
    CommentRepo commentRepo;


    @Autowired
    ModelMapper modelMapper;


    public List<Comment> getAll(){

        return commentRepo.findAll();
    }


    public CommentDto getById(long id) {

        Optional<Comment> comment = commentRepo.findById(id);
        return comment.map(value -> modelMapper.map(value, CommentDto.class)).orElse(null);

    }


    public Comment save(Comment comment) {
        return commentRepo.save(comment);
    }

    public Comment update(long id, Comment ucomment) {
        return commentRepo.findById(id)
                .map(comment -> {
                    comment.setName(ucomment.getName());
                    comment.setId(id);
                    return commentRepo.save(comment);
                }).orElseGet(() -> {
                    ucomment.setId(id);
                    return commentRepo.save(ucomment);
                });
    }

    public void delete(long id) {
        commentRepo.deleteById(id);
    }

}
