package com.demo.mappingsdemo.onetoone.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "car")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car {

  @Column(name = "id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "maker")
  private String maker;

  @Column(name = "registration")
  private String registration;

  @OneToOne(fetch = FetchType.LAZY,
      cascade =  CascadeType.ALL,
      mappedBy = "car")
  private Driver driver;

}
