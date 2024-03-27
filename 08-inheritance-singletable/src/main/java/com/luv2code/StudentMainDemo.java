package com.luv2code;

import com.luv2code.entity.Status;
import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMainDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            Student tempStudent1 = new Student("John", "Doe", "john@luv2code.com", Status.ACTIVE);
            Student tempStudent2 = new Student("Mary", "Public", "mary@luv2code.com", Status.INACTIVE);

            session.beginTransaction();
            System.out.println("Saving students...");
            session.persist(tempStudent1);
            session.persist(tempStudent2);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
    }
}