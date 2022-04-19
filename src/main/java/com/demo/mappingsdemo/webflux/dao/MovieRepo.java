package com.demo.mappingsdemo.webflux.dao;

import com.demo.mappingsdemo.webflux.model.Movie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends CrudRepository<Movie, Long> {

  List<Movie> findByYear(Integer year);
}
