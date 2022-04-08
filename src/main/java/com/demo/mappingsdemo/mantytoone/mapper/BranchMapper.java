package com.demo.mappingsdemo.mantytoone.mapper;

import com.demo.mappingsdemo.mantytoone.dto.AccountDto;
import com.demo.mappingsdemo.mantytoone.dto.BranchDto;
import com.demo.mappingsdemo.mantytoone.model.Account;
import com.demo.mappingsdemo.mantytoone.model.Branch;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BranchMapper {

  Branch map(BranchDto source);

  BranchDto map(Branch source);

  @Mappings({@Mapping(target="id", source="id")})
  List<BranchDto> map(List<Branch> source);

}
