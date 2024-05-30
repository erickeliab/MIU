package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.models.User;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<User> getAll(){

        return userRepo.findAll();
    }



    public User getById(long id){


        return userRepo.findById(id).get();

    }

    public User create(User user){

        return userRepo.save(user);


    }


    public User updateById(long id, User user){

        return userRepo.findById(id)
                .map(u -> {
                    u.setName(user.getName());
                    return userRepo.save(u);
                }).orElseGet(() -> {
                    user.setId(id);
                    return userRepo.save(user);
                });
    }


    public void deleteById(long id){

        userRepo.deleteById(id);
    }



    public User addPostToUser(Long id, Post post) {
        Optional<User> userOptional = userRepo.findById(id);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.addPost(post);
            postRepository.save(post);
            return userRepo.save(user);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }


}
