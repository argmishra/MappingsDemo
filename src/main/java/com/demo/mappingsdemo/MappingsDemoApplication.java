package com.demo.mappingsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MappingsDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(MappingsDemoApplication.class, args);
  }

}
