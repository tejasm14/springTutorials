package com.demo.firstSpring.tutorial.services;

import com.demo.firstSpring.tutorial.entities.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getCourses();
    Optional<Course> getCourse(Long id);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourseByTitle(String title);
    List<Course> getCourseContainingTitle(String title);
}
