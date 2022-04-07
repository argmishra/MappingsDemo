package com.demo.mappingsdemo.onetoone.controller;

import com.demo.mappingsdemo.onetoone.dto.CarDto;
import com.demo.mappingsdemo.onetoone.dto.DriverDto;
import com.demo.mappingsdemo.onetoone.service.CarService;
import com.demo.mappingsdemo.onetoone.service.DriverService;
import org.springframework.cache.annotation.Cacheable;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cars")
@Slf4j
@RequiredArgsConstructor
public class CarController {

  private final CarService carService;

  private final DriverService driverService;

  @PostMapping
  public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto){
    log.info("Create Car Request");
    CarDto car = carService.createCar(carDto);
    return new ResponseEntity<>(car, HttpStatus.CREATED);
  }

  @PutMapping("/{carId}")
  public ResponseEntity<CarDto> updateCar(@PathVariable Long carId, @RequestBody CarDto carDto){
    log.info("Update Car Request for id : {}", carId);
    CarDto cat = carService.updateCar(carId, carDto);
    return new ResponseEntity<>(cat, HttpStatus.OK);
  }

  @GetMapping("/{carId}")
  public ResponseEntity<CarDto> getCar(@PathVariable Long carId){
    log.info("Get Car Request for id : {}", carId);
    CarDto cat = carService.getCar(carId);
    return new ResponseEntity<>(cat, HttpStatus.OK);
  }

  @DeleteMapping("/{carId}")
  public ResponseEntity<Void> deleteCar(@PathVariable Long carId){
    log.info("Delete Car Request for id : {}", carId);
    carService.deleteCar(carId);
    return new ResponseEntity(HttpStatus.OK);
  }

  @PostMapping("/{carId}/driver")
  public ResponseEntity<DriverDto> createCar(@RequestBody DriverDto driverDto, @PathVariable Long carId){
    log.info("Create Driver Request for carId : {}", carId);
    DriverDto driver = driverService.createDriver(carId, driverDto);
    return new ResponseEntity<>(driver, HttpStatus.CREATED);
  }


}
