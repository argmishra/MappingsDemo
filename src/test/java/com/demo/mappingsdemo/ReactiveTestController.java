package com.demo.mappingsdemo;

import com.demo.mappingsdemo.webflux.controller.ReactiveController;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@WebFluxTest(controllers = ReactiveController.class)
public class ReactiveTestController {

  @Autowired
  WebTestClient webTestClient;

  @Test
  void test1() {
    webTestClient
        .get()
        .uri("/flux")
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBodyList(Integer.class)
        .hasSize(5);
  }

  @Test
  void test2() {
    Flux flux = webTestClient
        .get()
        .uri("/flux")
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .returnResult(Integer.class)
        .getResponseBody();

    StepVerifier.create(flux)
        .expectNext(1, 2, 3)
        .expectComplete();
  }

  @Test
  void test3() {
    webTestClient
        .get()
        .uri("/flux")
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .expectBodyList(Integer.class)
        .consumeWith(listEntityExchangeResult -> {
          List responseBody = listEntityExchangeResult.getResponseBody();
          assert (responseBody != null ? responseBody.size() : 0) == 5;
        });
  }

  @Test
  void test4() {
    Flux flux = webTestClient
        .get()
        .uri("/stream")
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .returnResult(Integer.class)
        .getResponseBody();

    StepVerifier.create(flux)
        .expectNext(0, 1, 2)
        .thenCancel()
        .verify();
  }

  @Test
  void test5() {
    Flux flux = webTestClient
        .get()
        .uri("/mono")
        .exchange()
        .expectStatus()
        .is2xxSuccessful()
        .returnResult(Integer.class)
        .getResponseBody();

    StepVerifier.create(flux)
        .expectNext(1)
        .expectComplete();
  }
}
