package com.demo.mappingsdemo.manytomany.service;

import com.demo.mappingsdemo.manytomany.dao.StudentDao;
import com.demo.mappingsdemo.manytomany.dto.StudentDto;
import com.demo.mappingsdemo.manytomany.mapper.StudentMapper;
import com.demo.mappingsdemo.manytomany.model.Student;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

  private final StudentMapper studentMapper;

  private final StudentDao studentDao;

  public StudentDto createStudent(StudentDto StudentDto){
    Student Student = studentMapper.map(StudentDto);
    Student = studentDao.save(Student);
    return studentMapper.map(Student);
  }

  public Student getStudentById(Long accountId){
    return studentDao.findById(accountId).get();
  }

  public StudentDto getStudent(Long accountId){
    Student Student = getStudentById(accountId);
    return studentMapper.map(Student);
  }

  public void deleteStudent(Long accountId){
    studentDao.deleteById(accountId);
  }

  public List<StudentDto> getAllStudents(){
    List<Student> accountList = studentDao.findAll();
    return studentMapper.map(accountList);
  }
}
