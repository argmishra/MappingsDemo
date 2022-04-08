package com.demo.mappingsdemo.onetoone.mapper;

import com.demo.mappingsdemo.onetoone.dto.CarDto;
import com.demo.mappingsdemo.onetoone.model.Car;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface CarMapper {

  @Mappings({@Mapping(target="id", source="source.car_id")})
  Car map(CarDto source);

  @Mappings({@Mapping(target="car_id", source="source.id")})
  CarDto map(Car source);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  @Mappings({@Mapping(target="id", source="car_id")})
  void updateCarFromCarDto(CarDto carDto, @MappingTarget Car car);

  @Mappings({@Mapping(target="car_id", source="source.id")})
  List<CarDto> map(List<Car> source);

}
