package com.demo.mappingsdemo.manytomany.mapper;

import com.demo.mappingsdemo.manytomany.dto.CourseDto;
import com.demo.mappingsdemo.manytomany.model.Course;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

  @Mapping(target = "source.course", ignore = true)
  Course map(CourseDto source);

  CourseDto map(Course source);

  List<CourseDto> map(List<Course> source);

  List<CourseDto> map(Set<Course> source);
}
