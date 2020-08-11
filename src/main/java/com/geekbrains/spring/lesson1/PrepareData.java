package com.geekbrains.spring.lesson1;

import org.hibernate.Session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrepareData {
    public static void forcePrepareData(MySessionFactory sessionFactory) {
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("script1.sql")).collect(Collectors.joining(" "));
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sessionFactory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
