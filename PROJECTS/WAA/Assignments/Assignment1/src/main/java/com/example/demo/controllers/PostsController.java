package com.example.demo.controllers;
import com.example.demo.models.IPost;
import com.example.demo.models.Post;
import com.example.demo.models.dto.response.PostDto;
import com.example.demo.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostsController {

    @Autowired
    PostsService postsService;
    @GetMapping
    public List<IPost> getAll(){
        return postsService.getAll();
    }


    @GetMapping("/filter")
    public List<IPost> getFiltered(@RequestParam("author") String author){
        return postsService.getFiltered(author);
    }


    @GetMapping("/contains")
    public List<IPost> getContains(@RequestParam("text") String text){
        return postsService.getContains(text);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDto getById(@PathVariable("id") long id){

        return postsService.getById(id);

    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Post p){
        postsService.create(p);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public IPost update(@RequestBody Post p, @PathVariable("id") long id){
        return postsService.updateById(id,p);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public  IPost delete(@PathVariable("id") long id){
        return postsService.deleteById(id);
    }


}
