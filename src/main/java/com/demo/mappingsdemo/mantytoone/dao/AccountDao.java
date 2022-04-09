package com.demo.mappingsdemo.mantytoone.dao;

import com.demo.mappingsdemo.mantytoone.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {

  @Query(value = "SELECT a FROM account a where a.branch.id = ?1")
  Account getAccountByBranchId(Long pageId);
}