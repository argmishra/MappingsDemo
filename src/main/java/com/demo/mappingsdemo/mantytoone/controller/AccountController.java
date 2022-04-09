package com.demo.mappingsdemo.mantytoone.controller;

import com.demo.mappingsdemo.mantytoone.dto.AccountDto;
import com.demo.mappingsdemo.mantytoone.dto.BranchDto;
import com.demo.mappingsdemo.mantytoone.service.AccountService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
@Slf4j
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @PostMapping("/{branchId}")
  public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto, @PathVariable Long branchId){
    log.info("Create Account Request");
    AccountDto account = accountService.createAccount(accountDto, branchId);
    return new ResponseEntity<>(account, HttpStatus.CREATED);
  }

  @GetMapping("/{accountId}")
  public ResponseEntity<AccountDto> getAccount(@PathVariable Long accountId){
    log.info("Get Account Request for id : {}", accountId);
    AccountDto account = accountService.getAccount(accountId);
    return new ResponseEntity<>(account, HttpStatus.OK);
  }

  @DeleteMapping("/{accountId}")
  public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId){
    log.info("Delete Account Request for id : {}", accountId);
    accountService.deleteAccount(accountId);
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<AccountDto>> getAllAccounts(){
    log.info("Get All Account Request ");
    List<AccountDto> accountList = accountService.getAllAccounts();
    return new ResponseEntity<>(accountList, HttpStatus.OK);
  }

  @GetMapping("/{accountId}/branch")
  public ResponseEntity<BranchDto> getBranchByAccount(@PathVariable Long accountId){
    log.info("Get Branch Request for account id : {}", accountId);
    BranchDto branch = accountService.getBranchByAccount(accountId);
    return new ResponseEntity<>(branch, HttpStatus.OK);
  }

  // Add account to branch - Possible by createAccount method
  // Get all branch by account - Possible by getBranchByAccount method
  // Delete branch from account - Not Possible as branch is parent entity


}
