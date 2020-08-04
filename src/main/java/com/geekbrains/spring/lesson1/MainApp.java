package com.geekbrains.spring.lesson1;

import com.geekbrains.spring.lesson1.beans.MySessionFactory;
import com.geekbrains.spring.lesson1.beans.ProductService;
import com.geekbrains.spring.lesson1.beans.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Lesson1Config.class);
        MySessionFactory sessionFactory = context.getBean("SessionFactory", MySessionFactory.class);
        ProductService productService = context.getBean("ProductService", ProductService.class);
        UserService userService = context.getBean("UserService", UserService.class);
        PrepareData.forcePrepareData();

        for (User user: userService.getAllUsers()
             ) {
            System.out.println(user.getId() + " " + user.getName() + " " + user.getAge());
        }

        for (Product product: productService.getAllProducts()
             ) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
        }

        productService.saveProduct("bacon", 100);

        for (Product product: productService.getAllProducts()
        ) {
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
        }

        context.close();
    }


}
