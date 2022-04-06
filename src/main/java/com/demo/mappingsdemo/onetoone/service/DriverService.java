package com.demo.mappingsdemo.onetoone.service;

import com.demo.mappingsdemo.onetoone.dao.CarDao;
import com.demo.mappingsdemo.onetoone.dao.DriverDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DriverService {

  @Autowired
  private DriverDao driverDao;

}
