package com.demo.mappingsdemo.onetomany.dao;


import com.demo.mappingsdemo.onetomany.model.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageDao extends JpaRepository<Page, Long> {
}
