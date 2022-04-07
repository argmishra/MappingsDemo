package com.demo.mappingsdemo.onetoone.controller;

import com.demo.mappingsdemo.onetoone.dto.CarDto;
import com.demo.mappingsdemo.onetoone.service.CarService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
@Slf4j
public class CarController {

  @Autowired
  private CarService carService;

  @PostMapping
  public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto){
    log.info("Create Car Request");

    CarDto cat = carService.createCar(carDto);

    return new ResponseEntity<>(cat, HttpStatus.CREATED);
  }

}
