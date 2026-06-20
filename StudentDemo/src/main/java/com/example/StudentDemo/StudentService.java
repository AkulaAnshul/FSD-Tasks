package com.example.StudentDemo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public Student getStudent(int id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteStudent(int id) {
        repository.deleteById(id);
    }
}