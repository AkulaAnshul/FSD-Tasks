package com.example.StudentDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(
            CourseService courseService) {

        this.courseService = courseService;
    }

    @GetMapping
    public String courses(Model model) {

        model.addAttribute(
                "courses",
                courseService.getAllCourses());

        return "courses";
    }

    @GetMapping("/new")
    public String newCourse(Model model) {

        model.addAttribute(
                "course",
                new Course());

        return "course-form";
    }

    @PostMapping("/save")
    public String save(Course course) {

        courseService.save(course);

        return "redirect:/courses";
    }
}