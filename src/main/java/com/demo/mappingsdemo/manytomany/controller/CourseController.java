package com.demo.mappingsdemo.manytomany.controller;

import com.demo.mappingsdemo.manytomany.dto.CourseDto;
import com.demo.mappingsdemo.manytomany.dto.StudentDto;
import com.demo.mappingsdemo.manytomany.service.CourseService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("courses")
@Slf4j
@RequiredArgsConstructor
public class CourseController {

  private final CourseService courseService;
  
  @PostMapping
  public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto CourseDto){
    log.info("Create Course Request");
    CourseDto course = courseService.createCourse(CourseDto);
    return new ResponseEntity<>(course, HttpStatus.CREATED);
  }

  @GetMapping("/{courseId}")
  public ResponseEntity<CourseDto> getCourse(@PathVariable Long courseId){
    log.info("Get Course Request for id : {}", courseId);
    CourseDto course = courseService.getCourse(courseId);
    return new ResponseEntity<>(course, HttpStatus.OK);
  }

  @DeleteMapping("/{courseId}")
  public ResponseEntity<CourseDto> deleteCourse(@PathVariable Long courseId){
    log.info("Delete Course Request for id : {}", courseId);
    courseService.deleteCourse(courseId);
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<CourseDto>> getAllCourses(){
    log.info("Get All Course Request ");
    List<CourseDto> courseList = courseService.getAllCourses();
    return new ResponseEntity<>(courseList, HttpStatus.OK);
  }

  @PutMapping("/{courseId}/{studentId}")
  public ResponseEntity<Void> addCourseToStudent(@PathVariable Long studentId, @PathVariable Long courseId){
    log.info("Add student id {} to course id {}", courseId, studentId);
    courseService.addCourseToStudent(studentId, courseId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/{courseId}/students")
  public ResponseEntity<List<StudentDto>> getStudentsOfCourses(@PathVariable Long courseId){
    log.info("Get Students of course id :{} ", courseId);
    List<StudentDto> student = courseService.getStudentsOfCourses(courseId);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @DeleteMapping("/{courseId}/{studentId}")
  public ResponseEntity<Void> deleteCourseFromStudent(@PathVariable Long studentId, @PathVariable Long courseId){
    log.info("Delete student id {} to course id {}", courseId, studentId);
    courseService.deleteCourseFromStudent(studentId, courseId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  // Join Course with student - Possible by addCourseToStudent
  // Get Courses of students - Possible using getStudentsOfCourses method
  // Delete Course from student - Possible using deleteCourseFromStudent method


}
