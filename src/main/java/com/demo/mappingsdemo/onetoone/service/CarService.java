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
    return carMapper.map(car);
  }

  public CarDto getCar(Long carId){
    Car car = getCarById(carId);
    return carMapper.map(car);
  }

  public CarDto updateCar(Long carId, CarDto carDto){
    Car car = getCarById(carId);
    carMapper.updateCarFromCarDto(carDto, car);
    car = carDao.save(car);
    return carMapper.map(car);
  }

  public void deleteCar(Long carId){
   carDao.deleteById(carId);
  }

  public Car getCarById(Long carId){
    // Add Exception
    return carDao.findById(carId).get();
  }

}
