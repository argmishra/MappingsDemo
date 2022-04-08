package com.demo.mappingsdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PageNotFoundException extends RuntimeException    {

  public PageNotFoundException(String message) {
    super(message);
  }

}