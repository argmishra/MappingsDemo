package com.demo.mappingsdemo.onetoone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Entity(name = "car")
@Data
@Builder
public class Car {

  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "maker")
  private String maker;

  @Column(name = "registration")
  private String registration;

  @OneToOne
  @JoinColumn(name = "driver_id", referencedColumnName = "id")
  private Driver driver;

}
