package com.example.demo.models;

import com.example.demo.models.IPost;
import lombok.Getter;
import lombok.Setter;

import java.util.List;



public interface IUser {

    public long getId();

    public String getName();

//    public List<Post> getPost();
    
    public void setId(long id);
    
    public void setName(String name);
    
//    public void addPosts(Post post);
    
    


}
