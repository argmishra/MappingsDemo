package com.demo.mappingsdemo.onetoone.mapper;

import com.demo.mappingsdemo.onetoone.dto.DriverDto;
import com.demo.mappingsdemo.onetoone.model.Driver;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface DriverMapper {
  Driver map(DriverDto driverDto);

  DriverDto map(Driver driver);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateDriverFromDriverDto(DriverDto driverDto, @MappingTarget Driver driver);
}
