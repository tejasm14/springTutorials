package com.demo.firstSpring.tutorial.dao;

import com.demo.firstSpring.tutorial.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CourseDao extends JpaRepository<Course,Long> {

    @Query(value = "SELECT * FROM course c WHERE c.title = ?1", nativeQuery = true)
    List<Course> findCourseByTitle(String title);

    @Query(value = "SELECT * FROM course c WHERE c.title like %?1%", nativeQuery = true)
    List<Course> findByTitleContaining(String title);
}
