package com.demo.mappingsdemo.mantytoone.dao;


import com.demo.mappingsdemo.mantytoone.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchDao extends JpaRepository<Branch, Long> {
}
