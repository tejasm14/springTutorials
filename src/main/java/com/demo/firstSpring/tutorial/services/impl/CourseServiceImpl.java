package com.demo.firstSpring.tutorial.services.impl;

import com.demo.firstSpring.tutorial.dao.CourseDao;
import com.demo.firstSpring.tutorial.entities.Course;
import com.demo.firstSpring.tutorial.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

//    List<Course> courseList;
    @Autowired
    CourseDao courseDao;

    public CourseServiceImpl() {
//        courseList = new ArrayList<>();
//        courseList.add(new Course(101L,"Core Java Course","This is core java"));
//        courseList.add(new Course(102L,"SQL","THis is SQL"));
    }

    @Override
    public List<Course> getCourses() {
        return courseDao.findAll();
//        return courseList;
    }

    @Override
    public Optional<Course> getCourse(Long id) {
//        Course course = null;
//
//        for (Course clist :courseList) {
//            if (clist.getId() == id) {
//                course = clist;
//                break;
//            }
//        }
//        return course;
        return courseDao.findById(id);
    }

    @Override
    public Course addCourse(Course course) {
//        courseList.add(course);
//        return course;
        return courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course) {

//        courseList.forEach(s -> {
//            if (s.getId() == course.getId()) {
//                s.setTitle(course.getTitle());
//                s.setDescription(course.getDescription());
//            }
//        });
//        return course;
        return courseDao.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course entity = courseDao.getOne(id);
        courseDao.delete(entity);
    }

    @Override
    public List<Course> getCourseByTitle(String title) {
        return courseDao.findCourseByTitle(title);
    }

    @Override
    public List<Course> getCourseContainingTitle(String title) {
        return courseDao.findByTitleContaining(title);
    }

}
