package com.demo.mappingsdemo.onetomany.mapper;

import com.demo.mappingsdemo.onetomany.dto.BookDto;
import com.demo.mappingsdemo.onetomany.model.Book;
import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface BookMapper {

  Book map(BookDto source);

  BookDto map(Book source);

  List<BookDto> map(List<Book> source);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateBookFromBookDto(BookDto bookDto, @MappingTarget Book book);


}
