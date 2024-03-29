package com.luv2code.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue(value = "STUDENT")
@ToString
public class Student extends User {
    private String course;

    public Student(String firstName, String lastName, String email, String course) {
        super(firstName, lastName, email);
        this.course = course;
    }
}