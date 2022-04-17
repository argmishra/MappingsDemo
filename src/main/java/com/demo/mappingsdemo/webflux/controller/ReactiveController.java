package com.demo.mappingsdemo.webflux.controller;


import java.time.Duration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveController {

  @GetMapping("flux")
  public Flux<Integer> getFlux() {
    return Flux.just(1, 2, 3, 4, 5).log();
  }

  @GetMapping("mono")
  public Mono<Integer> getMono() {
    return Mono.just(1).log();
  }

  @GetMapping(value = "stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Long> getStream() {
    return Flux.interval(Duration.ofSeconds(1)).log();
  }

}
