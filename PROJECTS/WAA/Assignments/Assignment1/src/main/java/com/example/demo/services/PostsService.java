package com.example.demo.services;

import com.example.demo.models.IPost;

import com.example.demo.models.dto.response.PostDto;
import com.example.demo.repositories.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostsService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    ModelMapper modelMapper;

public List<IPost> getAll(){

    return postRepository.fetchAll();
}


public List<IPost> getFiltered(String author){

        return postRepository.fetchAll().stream().filter(p -> p.getAuthor().equals(author)).toList();
}


public List<IPost> getContains(String text){

    return postRepository.fetchAll().stream().filter(p -> p.getAuthor().contains(text)).toList();

}


public PostDto getById(long id){


    IPost post = postRepository.fetchById(id);
    return modelMapper.map(postRepository.fetchById(id), PostDto.class);


}

public void create(IPost p){

    postRepository.save(p);


}


public IPost updateById(long id, IPost post){

    return postRepository.update(id,post);
}



    public IPost deleteById(long id){

        return postRepository.delete(id);
    }


}
