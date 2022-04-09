package com.demo.mappingsdemo.manytomany.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

  private Long id;

  private String name;

  private String grade;

}
