package com.demo.firstSpring.tutorial.repositories;

import com.demo.firstSpring.tutorial.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts,Long> {

}
