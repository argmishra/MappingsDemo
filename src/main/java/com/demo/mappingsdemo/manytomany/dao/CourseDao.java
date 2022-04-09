package com.demo.mappingsdemo.manytomany.dao;

import com.demo.mappingsdemo.manytomany.dto.CourseDto;
import com.demo.mappingsdemo.manytomany.model.Course;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseDao extends JpaRepository<Course, Long> {

  @Query(value = "SELECT c FROM Course c where c.student = ?1")
  List<CourseDto> findAllCoursesByStudentId(Set<Long> student);
}
