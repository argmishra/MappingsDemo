package com.demo.mappingsdemo.onetoone.service;

import com.demo.mappingsdemo.onetoone.controller.CarController;
import com.demo.mappingsdemo.onetoone.dao.CarDao;
import com.demo.mappingsdemo.onetoone.dto.CarDto;
import com.demo.mappingsdemo.onetoone.mapper.CarMapper;
import com.demo.mappingsdemo.onetoone.model.Car;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class CarService {

  private static final Logger log = org.apache.logging.log4j.LogManager.getLogger(CarController.class);

  @Autowired
  private CarDao carDao;

  @Autowired
  CarMapper carMapper;

  public CarDto createCar(CarDto carDto){

    Car request = carMapper.map(carDto);

    Car car =  carDao.save(request);


    CarDto result = carMapper.map(car);

    return result;
  }

}
