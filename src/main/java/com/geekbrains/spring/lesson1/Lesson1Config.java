package com.geekbrains.spring.lesson1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.geekbrains.spring.lesson1.beans"})
public class Lesson1Config {
}
