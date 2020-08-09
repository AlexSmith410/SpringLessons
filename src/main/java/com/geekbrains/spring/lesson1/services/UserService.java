package com.geekbrains.spring.lesson1.services;

import com.geekbrains.spring.lesson1.models.User;
import com.geekbrains.spring.lesson1.repositories.UserRepo;
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

    public void saveUser(User user){
        userRepo.saveUser(user);
    }
}
