package com.demo.mappingsdemo.onetomany.dto;

import com.demo.mappingsdemo.onetomany.model.Page;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Set;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDto {

  private Long id;

  private String title;

  private String author;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Set<PageDto> pages;
}
