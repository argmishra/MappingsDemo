package com.demo.mappingsdemo.onetoone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

@Entity(name = "driver")
@Data
@Builder
public class Driver {

  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "age")
  private int age;

  @OneToOne(mappedBy = "driver")
  private Car car;
}
