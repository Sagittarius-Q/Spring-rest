package com.example.rest.model.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
}
