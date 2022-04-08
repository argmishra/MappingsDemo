package com.demo.mappingsdemo.onetomany.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PageDto {

  private Long id;

  private int number;

}
