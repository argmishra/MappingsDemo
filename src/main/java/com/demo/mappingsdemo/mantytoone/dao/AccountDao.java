package com.demo.mappingsdemo.mantytoone.dao;

import com.demo.mappingsdemo.mantytoone.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {
}