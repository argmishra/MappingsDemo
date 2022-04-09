package com.demo.mappingsdemo.mantytoone.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

  private Long id;

  private int number;

  private BranchDto branch;
}
