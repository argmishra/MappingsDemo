package com.demo.mappingsdemo.onetoone.controller;

import com.demo.mappingsdemo.onetoone.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("drivers")
public class DriverController {

  @Autowired
  private DriverService driverService;


}