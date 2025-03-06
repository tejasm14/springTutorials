package com.demo.firstSpring.tutorial.Controllers;

import com.demo.firstSpring.tutorial.entities.Course;
import com.demo.firstSpring.tutorial.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home() {
        return "This is home";
    }

    //List all the courses
    @GetMapping("/courses")
    public List<Course> getCourses() {
        return this.courseService.getCourses();
    }

    //course with id
    @GetMapping("/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable Long courseId) {
        return this.courseService.getCourse(courseId);
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course) {
        return this.courseService.addCourse(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/courses/title/{title}")
    public List<Course> getCourseByTitle(@PathVariable String title) {
        return courseService.getCourseByTitle(title);
    }

    @GetMapping(path = "/courses/titleContaining/{title}")
    private List<Course> getCourseContainingTitle(@PathVariable String title) {
        return courseService.getCourseContainingTitle(title);
    }

}
