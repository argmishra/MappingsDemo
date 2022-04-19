package com.demo.mappingsdemo.webflux.mapper;

import com.demo.mappingsdemo.onetomany.dto.BookDto;
import com.demo.mappingsdemo.onetomany.model.Book;
import com.demo.mappingsdemo.webflux.dto.MovieDto;
import com.demo.mappingsdemo.webflux.model.Movie;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MovieMapper {

  Movie map(MovieDto movieDto);

  MovieDto map(Movie movie);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateMovieFromMovieDto(MovieDto movieDto, @MappingTarget Movie movie);

}
