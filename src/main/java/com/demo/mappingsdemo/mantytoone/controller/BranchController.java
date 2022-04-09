package com.demo.mappingsdemo.mantytoone.controller;

import com.demo.mappingsdemo.mantytoone.dto.AccountDto;
import com.demo.mappingsdemo.mantytoone.dto.BranchDto;
import com.demo.mappingsdemo.mantytoone.service.BranchService;
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
@RequestMapping("branches")
@Slf4j
@RequiredArgsConstructor
public class BranchController {

  private final BranchService branchService;

  @PostMapping
  public ResponseEntity<BranchDto> createBranch(@RequestBody BranchDto branchDto){
    log.info("Create Branch Request");
    BranchDto branch = branchService.createBranch(branchDto);
    return new ResponseEntity<>(branch, HttpStatus.CREATED);
  }

  @GetMapping("/{branchId}")
  public ResponseEntity<BranchDto> getBranch(@PathVariable Long branchId){
    log.info("Get Branch Request for id : {}", branchId);
    BranchDto branch = branchService.getBranch(branchId);
    return new ResponseEntity<>(branch, HttpStatus.OK);
  }

  @DeleteMapping("/{branchId}")
  public ResponseEntity<Void> deleteBranch(@PathVariable Long branchId){
    log.info("Delete Branch Request for id : {}", branchId);
    branchService.deleteBranch(branchId);
    return new ResponseEntity(HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<BranchDto>> getAllBranch(){
    log.info("Get All Branch Request ");
    List<BranchDto> branchList = branchService.getAllBranch();
    return new ResponseEntity<>(branchList, HttpStatus.OK);
  }

  @GetMapping("/{branchId}/account")
  public ResponseEntity<AccountDto> getAccountByBranch(@PathVariable Long branchId){
    log.info("Get Branch Request for account id : {}", branchId);
    AccountDto account = branchService.getAccountByBranch(branchId);
    return new ResponseEntity<>(account, HttpStatus.OK);
  }

  // Get all account by branch - Possible by getAccountByBranch method
  // Delete account from branch - Possible by deleteAccount method





}
