package com.example.demo.controllers;
import com.example.demo.models.Post;
import com.example.demo.models.User;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/manyposts")
    public List<User> getAllWithMany(){

        return userService.getAll().stream().filter(user -> user.getPosts().size() > 1).toList();

    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") long id){

        return userService.getById(id);

    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<Post> getUserPostsById(@PathVariable("id") long id){

        return userService.getById(id).getPosts();

    }

    @PostMapping("/{id}/posts")
    public User addPostToUser(@PathVariable("id") Long id, @RequestBody Post post) {
        return userService.addPostToUser(id, post);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody User user){
        userService.create(user);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable("id") long id){
        return userService.updateById(id,user);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable("id") long id){
         userService.deleteById(id);
    }


}
