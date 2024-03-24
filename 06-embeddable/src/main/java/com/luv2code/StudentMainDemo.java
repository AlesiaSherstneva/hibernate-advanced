package com.luv2code;

import com.luv2code.entity.Address;
import com.luv2code.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentMainDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            Student tempStudent = new Student("John", "Doe", "john@luv2code.com");
            Address homeAddress = new Address("Some Street", "Some City", "12345");
            Address billingAddress = new Address("Some Street", "Some City", "12345");

            session.beginTransaction();
            System.out.println("Saving the student and two addresses...");
            tempStudent.setHomeAddress(homeAddress);
            tempStudent.setBillingAddress(billingAddress);
            session.persist(tempStudent);
            session.getTransaction().commit();
            System.out.println("Done!!!");
        }
    }
}