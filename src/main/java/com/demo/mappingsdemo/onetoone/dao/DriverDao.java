package com.demo.mappingsdemo.onetoone.dao;

import com.demo.mappingsdemo.onetoone.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDao extends JpaRepository<Driver, Long> {
}
