package com.demo.mappingsdemo.config;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
@Slf4j
@RequiredArgsConstructor
public class AuthorController {

  private final AuthorDao authorDao;

  @GetMapping
  @Cacheable(value="carInfo")
  public ResponseEntity<List<Author>> getAllAuthor(){
    log.info("Get all author");
    List<Author> authorList = authorDao.findAll();
    return new ResponseEntity<>(authorList, HttpStatus.OK);
  }

}
