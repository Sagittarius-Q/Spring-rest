package com.example.rest.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Student {
    @Id
    @SequenceGenerator(name = "student_seq", allocationSize = 1)
    @GeneratedValue(generator = "student_seq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

}
