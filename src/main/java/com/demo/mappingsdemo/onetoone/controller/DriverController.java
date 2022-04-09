package com.demo.mappingsdemo.onetoone.controller;

import com.demo.mappingsdemo.onetoone.dto.CarDto;
import com.demo.mappingsdemo.onetoone.dto.DriverDto;
import com.demo.mappingsdemo.onetoone.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("drivers")
@Slf4j
@RequiredArgsConstructor
public class DriverController {

  private final DriverService driverService;

  @PutMapping("/{driverId}")
  public ResponseEntity<DriverDto> updateDriver(@PathVariable Long driverId, @RequestBody DriverDto driverDto){
    log.info("Update Driver Request for id : {}", driverId);
    DriverDto driver = driverService.updateDriver(driverId, driverDto);
    return new ResponseEntity<>(driver, HttpStatus.OK);
  }

  @GetMapping("/{driverId}")
  public ResponseEntity<DriverDto> getDriver(@PathVariable Long driverId){
    log.info("Get Driver Request for id : {}", driverId);
    DriverDto driver = driverService.getDriver(driverId);
    return new ResponseEntity<>(driver, HttpStatus.OK);
  }

  @DeleteMapping("/{driverId}")
  public ResponseEntity<Void> deleteCar(@PathVariable Long driverId){
    log.info("Delete Driver Request for id : {}", driverId);
    driverService.deleteDriver(driverId);
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping("/{driverId}/cars")
  public ResponseEntity<CarDto> getCarsByDriver(@PathVariable Long driverId){
    log.info("Get Car Request for driver id : {}", driverId);
    CarDto car = driverService.getCarsByDriver(driverId);
    return new ResponseEntity<>(car, HttpStatus.OK);
  }

  // Delete car from driver - Not Possible as car is parent entity
  // Get all cars by driver - Possible by getCarsByDriver method

}
