package com.example.demo.controllers;
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
    public List<Post> getAll(){
        return postsService.fetchAll();
    }


    @GetMapping("/filter")
    public List<PostDto> getFiltered(@RequestParam("author") String author){
        return postsService.getFiltered(author);
    }


    @GetMapping("/contains")
    public List<PostDto> getContains(@RequestParam("text") String text){
        return postsService.getContains(text);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PostDto getById(@PathVariable("id") long id){

        return postsService.fetchById(id);

    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@RequestBody Post p){
        postsService.save(p);
    }


    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public Post update(@RequestBody Post p, @PathVariable("id") long id){
        return postsService.update(id,p);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public  void delete(@PathVariable("id") long id){
         postsService.delete(id);
    }


}
