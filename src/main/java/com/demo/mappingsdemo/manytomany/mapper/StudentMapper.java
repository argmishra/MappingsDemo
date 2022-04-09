package com.demo.mappingsdemo.manytomany.mapper;

import com.demo.mappingsdemo.manytomany.dto.StudentDto;
import com.demo.mappingsdemo.manytomany.model.Student;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

  @Mapping(target = "source.student", ignore = true)
  Student map(StudentDto source);

  StudentDto map(Student source);

  List<StudentDto> map(List<Student> source);
}
