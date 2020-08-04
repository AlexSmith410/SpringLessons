package com.geekbrains.spring.lesson1.beans;

import com.geekbrains.spring.lesson1.User;
import com.geekbrains.spring.lesson1.beans.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "UserService")
public class UserService {
    private UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    public User getUserById(Long id){
        return userRepo.getUserById(id);
    }

    public List<User> getAllUsers(){
        return userRepo.getAllUsers();
    }

    public void saveUser(String name, int age){
        userRepo.saveUser(name, age);
    }
}
