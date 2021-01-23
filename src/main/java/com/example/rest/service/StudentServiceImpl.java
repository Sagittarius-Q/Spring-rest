package com.example.rest.service;

import com.example.rest.model.dto.StudentDto;
import com.example.rest.model.entity.Student;
import com.example.rest.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
    @Override
    public void save(StudentDto studentDto) {
        Student student = this.modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students =studentRepository.findAll();
        return students
                .stream()
                .map(item -> this.modelMapper.map(item,StudentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto getById(Long id) {
        Student student = studentRepository.getById(id);
        return this.modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updateById(Long id, StudentDto studentDto) {
        Student student = studentRepository.getById(id);
        if(student == null) return null;
        student.setId(id);
        student.setAge(studentDto.getAge());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        studentRepository.save(student);
        return this.modelMapper.map(student , StudentDto.class);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
