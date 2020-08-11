package com.geekbrains.spring.lesson1.controllers;

import com.geekbrains.spring.lesson1.models.User;
import com.geekbrains.spring.lesson1.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUsers(Model model) {
        model.addAttribute("Users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/show_user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        model.addAttribute("Users", userService.getUserById(id));
        return "user_page";
    }

    @GetMapping("/add")
    public String showUserAddForm() {
        return "add_user_form";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users/all";
    }
}
