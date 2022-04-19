package com.demo.mappingsdemo.webflux.dto;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {

  private Long id;

  private String name;

  @Positive(message = "Year must positive")
  private Integer year;

  private String cast;
}
