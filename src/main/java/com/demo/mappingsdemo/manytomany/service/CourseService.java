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
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CourseService {

  private final CourseMapper courseMapper;

  private final CourseDao courseDao;

  private final StudentDao studentDao;

  private final StudentMapper studentMapper;

  public CourseDto createCourse(CourseDto courseDto){
    Course course = courseMapper.map(courseDto);
    course = courseDao.save(course);
    return courseMapper.map(course);
  }

  public Course getCourseById(Long courseId){
    return courseDao.findById(courseId).get();
  }

  public CourseDto getCourse(Long courseId){
    Course Course = getCourseById(courseId);
    return courseMapper.map(Course);
  }

  public void deleteCourse(Long courseId){
    courseDao.deleteById(courseId);
  }

  public List<CourseDto> getAllCourses(){
    List<Course> accountList = courseDao.findAll();
    return courseMapper.map(accountList);
  }

  public void addCourseToStudent(Long studentId, Long courseId) {
    Student student = studentDao.getOne(studentId);
    Course course = courseDao.getOne(courseId);
    student.getCourse().add(course);
    courseDao.save(course);
  }

  public List<StudentDto> getStudentsOfCourses(Long courseId){
    Course course = getCourseById(courseId);
    return studentMapper.map(course.getStudent());
  }

  public void deleteCourseFromStudent(Long studentId, Long courseId) {
    Student student = studentDao.getOne(studentId);
    Course course = courseDao.getOne(courseId);
    student.getCourse().remove(course);
    courseDao.save(course);
  }
}
