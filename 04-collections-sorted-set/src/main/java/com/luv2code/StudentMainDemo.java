package com.luv2code;

import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Set;

public class StudentMainDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

            Set<String> theImages = tempStudent.getImages();
            theImages.add("photo1.jpg");
            theImages.add("photo2.jpg");
            theImages.add("photo3.jpg");
            theImages.add("photo4.jpg");
            theImages.add("photo5.jpg");

            session.beginTransaction();
            System.out.println("Saving the student and images...");
            session.persist(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
    }
}