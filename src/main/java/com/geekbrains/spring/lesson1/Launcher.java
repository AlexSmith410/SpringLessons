package com.geekbrains.spring.lesson1;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.net.URL;
import java.security.ProtectionDomain;

public class Launcher {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8189);

        ProtectionDomain domain = Launcher.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Lesson1Config.class);
        MySessionFactory sessionFactory = context.getBean("SessionFactory", MySessionFactory.class);
        PrepareData.forcePrepareData(sessionFactory);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/app");
        webAppContext.setWar(location.toExternalForm());

        server.setHandler(webAppContext);
        server.start();
        server.join();
    }
}