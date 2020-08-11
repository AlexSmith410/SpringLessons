package com.geekbrains.spring.lesson1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String showIndexPage() {
        return "index";
    }
}
