package com.example.StudentDemo;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course save(Course course) {
        return repository.save(course);
    }
}