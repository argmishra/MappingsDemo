package com.demo.mappingsdemo.manytomany.service;

import com.demo.mappingsdemo.manytomany.dao.CourseDao;
import com.demo.mappingsdemo.manytomany.dto.CourseDto;
import com.demo.mappingsdemo.manytomany.mapper.CourseMapper;
import com.demo.mappingsdemo.manytomany.model.Course;
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

  public CourseDto createCourse(CourseDto courseDto){
    Course course = courseMapper.map(courseDto);
    course = courseDao.save(course);
    return courseMapper.map(course);
  }

  public Course getCourseById(Long accountId){
    return courseDao.findById(accountId).get();
  }

  public CourseDto getCourse(Long accountId){
    Course Course = getCourseById(accountId);
    return courseMapper.map(Course);
  }

  public void deleteCourse(Long accountId){
    courseDao.deleteById(accountId);
  }

  public List<CourseDto> getAllCourses(){
    List<Course> accountList = courseDao.findAll();
    return courseMapper.map(accountList);
  }
}
