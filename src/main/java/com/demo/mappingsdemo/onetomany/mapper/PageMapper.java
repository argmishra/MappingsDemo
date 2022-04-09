package com.demo.mappingsdemo.onetomany.mapper;

import com.demo.mappingsdemo.onetomany.dto.PageDto;
import com.demo.mappingsdemo.onetomany.model.Page;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PageMapper {

  Page map(PageDto source);

  PageDto map(Page source);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updatePageFromPageDto(PageDto pageDto, @MappingTarget Page page);

  @Mappings({@Mapping(target="id", source="id")})
  List<PageDto> map(List<Page> source);
}
