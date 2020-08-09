package com.geekbrains.spring.lesson1.beans;

import com.geekbrains.spring.lesson1.User;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepo {
    private Session session;
    private MySessionFactory sessionFactory;

    @Autowired
    public UserRepo(MySessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        session = null;
    }

    public User getUserById(Long id){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> getAllUsers(){
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<User> users = session.createQuery("Select u FROM User u", User.class).getResultList();
        session.close();
        return users;
    }

    public void saveUser(String name, int age){
        User user = new User(name, age);
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }
}
