package com.demo.mappingsdemo.manytomany.service;

import com.demo.mappingsdemo.manytomany.dao.CourseDao;
import com.demo.mappingsdemo.manytomany.dao.StudentDao;
import com.demo.mappingsdemo.manytomany.dto.CourseDto;
import com.demo.mappingsdemo.manytomany.dto.StudentDto;
import com.demo.mappingsdemo.manytomany.mapper.CourseMapper;
import com.demo.mappingsdemo.manytomany.mapper.StudentMapper;
import com.demo.mappingsdemo.manytomany.model.Course;
import com.demo.mappingsdemo.manytomany.model.Student;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {

  private final StudentMapper studentMapper;

  private final StudentDao studentDao;

  private final CourseDao courseDao;

  private final CourseMapper courseMapper;

  public StudentDto createStudent(StudentDto StudentDto){
    Student Student = studentMapper.map(StudentDto);
    Student = studentDao.save(Student);
    return studentMapper.map(Student);
  }

  public Student getStudentById(Long studentId){
    return studentDao.findById(studentId).get();
  }

  public StudentDto getStudent(Long studentId){
    Student Student = getStudentById(studentId);
    return studentMapper.map(Student);
  }

  public void deleteStudent(Long studentId){
    studentDao.deleteById(studentId);
  }

  public List<StudentDto> getAllStudents(){
    List<Student> accountList = studentDao.findAll();
    return studentMapper.map(accountList);
  }

  public List<CourseDto> getCoursesOfStudent(Long studentId){
    Student student = studentDao.getOne(studentId);
    Set<Course> course = student.getCourse();
    return courseMapper.map(course);
  }

}
