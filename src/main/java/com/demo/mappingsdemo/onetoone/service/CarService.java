package com.demo.mappingsdemo.onetoone.service;


import com.demo.mappingsdemo.onetoone.dao.CarDao;
import com.demo.mappingsdemo.onetoone.dto.CarDto;
import com.demo.mappingsdemo.onetoone.mapper.CarMapper;
import com.demo.mappingsdemo.onetoone.model.Car;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarService {

  private final CarDao carDao;

  private final CarMapper carMapper;

  public CarDto createCar(CarDto carDto){
    Car car = carMapper.map(carDto);
    car = carDao.save(car);
    carDto =  carMapper.map(car);
    log.info("Create Car Id : {}", carDto.getId());

    return carDto;
  }

}
