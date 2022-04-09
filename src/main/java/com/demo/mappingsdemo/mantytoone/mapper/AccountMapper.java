package com.demo.mappingsdemo.mantytoone.mapper;

import com.demo.mappingsdemo.mantytoone.dto.AccountDto;
import com.demo.mappingsdemo.mantytoone.model.Account;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  Account map(AccountDto source);

  AccountDto map(Account source);

  @Mappings({@Mapping(target="id", source="id")})
  List<AccountDto> map(List<Account> source);

}
