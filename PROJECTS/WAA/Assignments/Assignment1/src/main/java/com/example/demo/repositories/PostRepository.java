package com.example.demo.repositories;

import com.example.demo.models.IPost;

import java.util.List;

public interface PostRepository {

    public List<IPost> fetchAll();

    public IPost fetchById(long id);

    public void save(IPost p);

    public IPost delete(long id);

    public IPost update(long id, IPost p);


}
