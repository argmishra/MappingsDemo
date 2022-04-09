package com.demo.mappingsdemo.manytomany.dao;

import com.demo.mappingsdemo.manytomany.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}
