package com.demo.mappingsdemo.onetoone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {

  private Long id;

  private String maker;

  private String registration;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private DriverDto driver;
}
