package com.demo.mappingsdemo.mantytoone.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchDto {

  private Long id;

  private String name;

}
