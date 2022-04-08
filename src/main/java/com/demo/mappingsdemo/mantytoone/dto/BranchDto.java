package com.demo.mappingsdemo.mantytoone.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BranchDto {

  private Long id;

  private String name;

}
