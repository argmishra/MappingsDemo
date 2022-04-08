package com.demo.mappingsdemo.mantytoone.dto;

import com.demo.mappingsdemo.mantytoone.model.Branch;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDto {

  private Long id;

  private int number;

  private BranchDto branch;
}
