package com.demo.mappingsdemo.mantytoone.service;

import com.demo.mappingsdemo.mantytoone.dao.AccountDao;
import com.demo.mappingsdemo.mantytoone.dto.AccountDto;
import com.demo.mappingsdemo.mantytoone.dto.BranchDto;
import com.demo.mappingsdemo.mantytoone.mapper.AccountMapper;
import com.demo.mappingsdemo.mantytoone.model.Account;
import com.demo.mappingsdemo.mantytoone.model.Branch;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService {

  private final AccountDao accountDao;

  private final AccountMapper accountMapper;

  private final BranchService branchService;

  public AccountDto createAccount(AccountDto accountDto, Long branchId){
    Branch branch = branchService.getBranchById(branchId);
    Account account = accountMapper.map(accountDto);
    account.setBranch(branch);
    account = accountDao.save(account);
    return accountMapper.map(account);
  }

  public Account getAccountById(Long accountId){
    return accountDao.findById(accountId).get();
  }

  public AccountDto getAccount(Long accountId){
    Account account = getAccountById(accountId);
    return accountMapper.map(account);
  }

  public void deleteAccount(Long accountId){
    accountDao.deleteById(accountId);
  }

  public List<AccountDto> getAllAccounts(){
    List<Account> accountList = accountDao.findAll();
    return accountMapper.map(accountList);
  }
}
