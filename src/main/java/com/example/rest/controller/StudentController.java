package com.example.rest.controller;

import com.example.rest.model.dto.StudentDto;
import com.example.rest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/api/students")
    public List<StudentDto> getAll(){
        return studentService.getAll();
    }
    @PostMapping("/api/student")
    public void doSave(@RequestBody StudentDto studentDto){
        studentService.save(studentDto);
    }
    @GetMapping("/api/student/{id}")
    public StudentDto getStudent(@PathVariable Long id){
        return studentService.getById(id);
    }
    @DeleteMapping("/api/student/{id}")
    public void doDelete(@PathVariable Long id){
        studentService.delete(id);
    }
    @PutMapping("/api/student/{id}")
    public StudentDto updateStudent(@RequestBody StudentDto studentDto, @PathVariable Long id){
        return studentService.updateById(id,studentDto);
    }
}
