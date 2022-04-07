package com.demo.mappingsdemo.onetoone.service;

import com.demo.mappingsdemo.exception.DriverNotFoundException;
import com.demo.mappingsdemo.onetoone.dao.CarDao;
import com.demo.mappingsdemo.onetoone.dao.DriverDao;
import com.demo.mappingsdemo.onetoone.dto.DriverDto;
import com.demo.mappingsdemo.onetoone.mapper.DriverMapper;
import com.demo.mappingsdemo.onetoone.model.Car;
import com.demo.mappingsdemo.onetoone.model.Driver;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class DriverService {

  public final DriverDao driverDao;

  public final CarService carService;

  public final DriverMapper driverMapper;

  public DriverDto createDriver(Long carId, DriverDto driverDto){
    Car car = carService.getCarById(carId);
    Driver driver = driverMapper.map(driverDto);
    driver.setCar(car);
    driver = driverDao.save(driver);
    return driverMapper.map(driver);
  }

  public DriverDto getDriver(Long driverId){
    Driver driver = getDriverById(driverId);
    return driverMapper.map(driver);
  }

  public DriverDto updateDriver(Long driverId, DriverDto driverDto){
    Driver driver = getDriverById(driverId);
    driverMapper.updateDriverFromDriverDto(driverDto, driver);
    driver = driverDao.save(driver);
    return driverMapper.map(driver);
  }

  public void deleteDriver(Long driverId){
    driverDao.deleteById(driverId);
  }

  private Driver getDriverById(Long driverId){
    Optional<Driver> driver  = driverDao.findById(driverId);
    driver.orElseThrow(() -> new DriverNotFoundException("Driver id "+ driverId + " not found" ));
    return driver.get();
  }
}
