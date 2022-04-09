package com.demo.mappingsdemo.manytomany.dto;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CourseDto {

  private Long id;

  private int module;

  private String title;

}
