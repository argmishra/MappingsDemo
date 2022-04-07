package com.demo.mappingsdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DriverNotFoundException extends RuntimeException    {

  public DriverNotFoundException(String message) {
    super(message);
  }

}