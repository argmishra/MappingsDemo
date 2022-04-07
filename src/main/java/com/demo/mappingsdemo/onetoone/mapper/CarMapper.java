package com.demo.mappingsdemo.onetoone.mapper;

import com.demo.mappingsdemo.onetoone.dto.CarDto;
import com.demo.mappingsdemo.onetoone.model.Car;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CarMapper {
  Car map(CarDto source);
  CarDto map(Car source);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateCarFromCarDto(CarDto carDto, @MappingTarget Car car);
}
