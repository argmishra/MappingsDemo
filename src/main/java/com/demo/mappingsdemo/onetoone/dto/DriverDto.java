package com.demo.mappingsdemo.onetoone.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DriverDto {

  private Long id;

  private String name;

  private Long age;
}
