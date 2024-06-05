package com.example.demo.repositories;

import com.example.demo.models.IUser;
import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    public User findByEmail(String email);
}
