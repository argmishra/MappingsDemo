package com.demo.mappingsdemo.onetoone.dao;

import com.demo.mappingsdemo.onetoone.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDao extends  JpaRepository<Car, Long> {

  @Query(value = "SELECT c FROM car c where c.driver.id = ?1")
  Car getCarsByDriver(Long id);
}
