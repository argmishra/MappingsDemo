package com.demo.mappingsdemo.onetomany.dao;

import com.demo.mappingsdemo.onetomany.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
}