package com.demo.mappingsdemo.manytomany.dao;

import com.demo.mappingsdemo.manytomany.model.Course;
import com.demo.mappingsdemo.manytomany.model.Student;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentDao extends JpaRepository<Student, Long> {

  @Query(value = "SELECT s FROM Student s where s.course IN (?1)")
  List<Student> getStudentsOfCourses(Set<Course> course);
}
