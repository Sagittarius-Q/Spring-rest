package com.example.rest.service;

import com.example.rest.model.dto.StudentDto;

import java.util.List;

public interface StudentService {
    public void save(StudentDto studentDto);
    public List<StudentDto> getAll();
    public StudentDto getById(Long id);
    public StudentDto updateById(Long id, StudentDto studentDto);
    public void delete(Long id);
}
