//package com.example.demo.repositories;
//
//import com.example.demo.models.IPost;
//import com.example.demo.models.IUser;
//import com.example.demo.models.User;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@AllArgsConstructor
//
//@Repository
//public class UserRepoImpl implements UserRepo {
//    static List<IUser> usersDB = new ArrayList<>();
//
//    static {
//
//        usersDB.add(new User(1,"eric"));
//        usersDB.add(new User(2,"erick"));
//        usersDB.add(new User(3,"erickk"));
//        usersDB.add(new User(4,"erickkk"));
//        usersDB.add(new User(5,"erickkkk"));
//        usersDB.add(new User(6,"erickkkkk"));
//        usersDB.add(new User(7,"erickkkkkk"));
//
//
//    }
//
//
////    @Override
//    public List<IUser> getAll() {
//
//        IUser user = new User(2,"Sample");
//
//        System.out.print(user.getId());
//        return usersDB;
//    }
//
//    @Override
//    public IUser getById(long id) {
//        Optional<IUser> userFound = usersDB.stream()
//                .filter(user -> user.getId() == id)
//                .findFirst();
//
//        return userFound.orElse(null);
//    }
//
//    @Override
//    public void insert(IUser body) {
//
//    }
//
//    @Override
//    public IUser update(IUser body, long id) {
//        return null;
//    }
//
//    @Override
//    public IUser delete(long id) {
//        return null;
//    }
//}
