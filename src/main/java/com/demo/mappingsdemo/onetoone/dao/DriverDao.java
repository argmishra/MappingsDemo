package com.demo.mappingsdemo.onetoone.dao;

import com.demo.mappingsdemo.onetoone.model.Car;
import com.demo.mappingsdemo.onetoone.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverDao extends JpaRepository<Driver, Long> {
}
