//package com.example.demo.repositories;
//
//import com.example.demo.models.IPost;
//import com.example.demo.models.Post;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Repository
//public abstract class PostRepositoryImpl implements PostRepository{
//
//    static List<IPost> posts = new ArrayList<>();
//
//    static {
//        posts.add(new Post(1,"Spring Boot in 30 days","JPA and Spring Security", "Anold"));
//        posts.add(new Post(2,"React in 30 days","React Dom and Redux", "Erick"));
//        posts.add(new Post(3,"Angular Boot in 30 days","Modular MVVM", "Kate"));
//        posts.add(new Post(4,"Kotlin in 30 days","Design Android Widgets", "Ibrahimovic"));
//
//    }
//
//    @Override
//    public List<IPost> fetchAll() {
//        return posts;
//    }
//
//    @Override
//    public IPost fetchById(long id) {
//
//        Optional<IPost> postFound = posts.stream()
//                .filter(post -> post.getId() == id)
//                .findFirst();
//
//        return postFound.orElse(null);
//
//    }
//
//    @Override
//    public void save(IPost p) {
//
//        posts.add(p);
//        return;
//    }
//
//    @Override
//    public IPost delete(long id) {
//        IPost toBeDeleted = posts.stream().filter(p -> p.getId() == id).findFirst().get();
//
//        posts = posts.stream().filter(p -> p.getId() != id).toList();
//
//        return toBeDeleted;
//    }
//
//    @Override
//    public IPost update(long id, IPost up) {
//
//        posts = posts.stream()
//                .map(p -> {
//                    if (p.getId() == id) {
//                        return up;
//                    } else {
//                        return p;
//                    }
//                }).toList();
//
//        return up;
//    }
//
//}
