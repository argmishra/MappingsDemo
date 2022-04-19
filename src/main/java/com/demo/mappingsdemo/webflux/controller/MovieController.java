package com.demo.mappingsdemo.webflux.controller;

import com.demo.mappingsdemo.webflux.dao.MovieRepo;
import com.demo.mappingsdemo.webflux.dto.MovieDto;
import com.demo.mappingsdemo.webflux.mapper.MovieMapper;
import com.demo.mappingsdemo.webflux.model.Movie;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("movies")
@Slf4j
@RequiredArgsConstructor
public class MovieController {

  private final MovieRepo movieRepo;

  private final MovieMapper movieMapper;

  @PostMapping
  public Mono<MovieDto> addMovie(@RequestBody @Valid MovieDto movieDto) {
    log.info("Create Movie Request");
    Movie movie =  movieRepo.save(movieMapper.map(movieDto));
    return Mono.just(movieMapper.map(movie));
  }

  @GetMapping("/{movieId}")
  public Mono<ResponseEntity<MovieDto>> getMovie(@PathVariable Long movieId) {
    log.info("Get Movie Request : {} ", movieId);
    Optional<Movie> movie = movieRepo.findById(movieId);
    return Mono.just(movieMapper.map(movie.get())).map(ResponseEntity.ok()::body).switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

  @DeleteMapping("/{movieId}")
  public void deleteMovie(@PathVariable Long movieId) {
    log.info("Delete Movie Request : {} ", movieId);
     movieRepo.deleteById(movieId);
  }

  @PutMapping("/{movieId}")
  public Mono<ResponseEntity<MovieDto>> updateMovie(@PathVariable Long movieId, @RequestBody MovieDto movieDto) {
    log.info("Update Movie Request : {} ", movieId);
    Optional<Movie> movie = movieRepo.findById(movieId);
    movieMapper.updateMovieFromMovieDto(movieDto, movie.get());
    movieRepo.save(movie.get());
    return Mono.just(movieMapper.map(movie.get())).map(ResponseEntity.ok()::body).switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
  }

 @GetMapping
  public Flux<MovieDto> getAllMovie(@RequestParam(value = "year", required = false) Optional<Integer> year) {
   List<MovieDto> movieList = new ArrayList<>();

    if(year.isPresent()){
      log.info("Get All Movie Request by year ; {} ", year);
      movieRepo.findByYear(year.get()).forEach(item -> movieList.add(movieMapper.map(item)));
      return Flux.fromIterable(movieList);
    }
    movieRepo.findAll().forEach(item -> movieList.add(movieMapper.map(item)));
    return Flux.fromIterable(movieList);
 }

}
