package com.example.StudentDemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository
        extends JpaRepository<Course,Integer> {
}