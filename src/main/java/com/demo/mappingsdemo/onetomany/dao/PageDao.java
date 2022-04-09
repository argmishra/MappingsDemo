package com.demo.mappingsdemo.onetomany.dao;


import com.demo.mappingsdemo.onetomany.model.Page;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PageDao extends JpaRepository<Page, Long> {

  @Query(value = "SELECT p FROM page p where p.book.id = ?1")
  List<Page> getAllPagesByBook(Long pageId);
}
