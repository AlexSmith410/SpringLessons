package com.geekbrains.spring.lesson1.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component(value = "SessionFactory")
public class MySessionFactory {
    private SessionFactory sessionFactory;

    public MySessionFactory(){
        this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

}
