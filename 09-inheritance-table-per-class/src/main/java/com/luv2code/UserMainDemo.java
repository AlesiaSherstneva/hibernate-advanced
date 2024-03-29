package com.luv2code;

import com.luv2code.entity.Instructor;
import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserMainDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            Student tempStudent = new Student("John", "Doe", "john@luv2code.com", "Hibernate");
            Instructor tempInstructor = new Instructor("Mary", "Public", "mary@luv2code.com", 20000.00);

            session.beginTransaction();
            System.out.println("Saving users...");
            session.persist(tempStudent);
            session.persist(tempInstructor);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
    }
}