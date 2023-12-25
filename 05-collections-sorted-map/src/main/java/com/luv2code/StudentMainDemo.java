package com.luv2code;

import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Map;

public class StudentMainDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            Student tempStudent = new Student("John", "Doe", "john@luv2code.com");

            Map<String, String> theImages = tempStudent.getImages();
            theImages.put("photo1.jpg", "Photo 1");
            theImages.put("photo2.jpg", "Photo 2");
            theImages.put("photo3.jpg", "Photo 3");

            session.beginTransaction();
            System.out.println("Saving the student and images...");
            session.persist(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
    }
}