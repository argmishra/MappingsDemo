package com.demo.mappingsdemo.mantytoone.service;

import com.demo.mappingsdemo.mantytoone.dao.AccountDao;
import com.demo.mappingsdemo.mantytoone.dao.BranchDao;
import com.demo.mappingsdemo.mantytoone.dto.AccountDto;
import com.demo.mappingsdemo.mantytoone.dto.BranchDto;
import com.demo.mappingsdemo.mantytoone.mapper.AccountMapper;
import com.demo.mappingsdemo.mantytoone.mapper.BranchMapper;
import com.demo.mappingsdemo.mantytoone.model.Account;
import com.demo.mappingsdemo.mantytoone.model.Branch;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BranchService {

  private final BranchDao branchDao;

  private final BranchMapper branchMapper;

  private final AccountDao accountDao;

  private final AccountMapper accountMapper;

  public BranchDto createBranch(BranchDto BranchDto){
    Branch branch = branchMapper.map(BranchDto);
    branch = branchDao.save(branch);
    return branchMapper.map(branch);
  }

  public Branch getBranchById(Long branchId){
    return branchDao.findById(branchId).get();
  }

  public BranchDto getBranch(Long branchId){
    Branch Branch = getBranchById(branchId);
    return branchMapper.map(Branch);
  }

  public void deleteBranch(Long branchId){
    branchDao.deleteById(branchId);
  }

  public List<BranchDto> getAllBranch(){
    List<Branch> branchList = branchDao.findAll();
    return branchMapper.map(branchList);
  }

  public AccountDto getAccountByBranch(Long branchId){
    Account account = accountDao.getAccountByBranchId(branchId);
    return accountMapper.map(account);

  }

}
