package com.demo.mappingsdemo.manytomany.dao;

import com.demo.mappingsdemo.manytomany.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course, Long> {
}
