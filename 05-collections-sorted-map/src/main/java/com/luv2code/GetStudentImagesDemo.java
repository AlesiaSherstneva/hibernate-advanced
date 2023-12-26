package com.luv2code;

import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetStudentImagesDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            int theId = 1;
            Student student = session.get(Student.class, theId);

            System.out.println(student);
            System.out.println("The associated images: " + student.getImages());

            session.getTransaction().commit();
            System.out.println("Done!");
        }
    }
}