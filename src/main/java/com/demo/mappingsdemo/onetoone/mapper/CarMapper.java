package com.demo.mappingsdemo.onetoone.mapper;

import com.demo.mappingsdemo.onetoone.dto.CarDto;
import com.demo.mappingsdemo.onetoone.model.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {

  Car map(CarDto source);

  CarDto map(Car source);

}
