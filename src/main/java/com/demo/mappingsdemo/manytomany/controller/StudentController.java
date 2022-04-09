package com.demo.mappingsdemo.manytomany.controller;

import com.demo.mappingsdemo.mantytoone.dto.AccountDto;
import com.demo.mappingsdemo.mantytoone.dto.BranchDto;
import com.demo.mappingsdemo.mantytoone.service.AccountService;
import com.demo.mappingsdemo.manytomany.dto.StudentDto;
import com.demo.mappingsdemo.manytomany.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
@Slf4j
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @PostMapping
  public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
    log.info("Create Student Request");
    StudentDto student = studentService.createStudent(studentDto);
    return new ResponseEntity<>(student, HttpStatus.CREATED);
  }

  @GetMapping("/{studentId}")
  public ResponseEntity<StudentDto> getStudent(@PathVariable Long studentId){
    log.info("Get Student Request for id : {}", studentId);
    StudentDto student = studentService.getStudent(studentId);
    return new ResponseEntity<>(student, HttpStatus.OK);
  }

  @DeleteMapping("/{studentId}")
  public ResponseEntity<StudentDto> deleteStudent(@PathVariable Long studentId){
    log.info("Delete Student Request for id : {}", studentId);
    studentService.deleteStudent(studentId);
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<StudentDto>> getAllStudents(){
    log.info("Get All Student Request ");
    List<StudentDto> studentList = studentService.getAllStudents();
    return new ResponseEntity<>(studentList, HttpStatus.OK);
  }

  // Join student with Course
  // Get student for Courses
  // Delete Course from student


}
