package com.geekbrains.spring.lesson1.repositories;

import com.geekbrains.spring.lesson1.MySessionFactory;
import com.geekbrains.spring.lesson1.models.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepo {
    private Session session;
    private MySessionFactory sessionFactory;

    @Autowired
    public ProductRepo(MySessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session = null;
    }

    public Product getProductById(Long id) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    public List<Product> getAllProducts() {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Product> products = session.createQuery("Select p FROM Product p", Product.class).getResultList();
        session.close();
        return products;
    }

    public void saveProduct(Product product) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }
}