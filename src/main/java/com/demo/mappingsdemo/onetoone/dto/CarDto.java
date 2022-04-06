package com.demo.mappingsdemo.onetoone.dto;

import com.demo.mappingsdemo.onetoone.model.Driver;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDto {

  private Long id;

  private String maker;

  private String registration;

  private Driver driver;
}
