package com.example.RestfulApi.services.imp;

import com.example.RestfulApi.dto.AccountDto;
import com.example.RestfulApi.entities.Account;
import com.example.RestfulApi.repository.AccountRepository;
import com.example.RestfulApi.request.CreateAccountRequest;
import com.example.RestfulApi.request.UpdateAccountRequest;
import com.example.RestfulApi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<AccountDto> getAccountByIdOrMobile(int id, String mobile) {
        List<Account> accounts = accountRepository.findByIdOrMobile(id, mobile);
        List<AccountDto> accountDtos = new ArrayList<AccountDto>();
        for (Account account: accounts) {
            accountDtos.add(new AccountDto(account.getId(), account.getName(),
                    account.getMobile(), account.getAge(), account.getAddress()));
        }
        return accountDtos;
    }

    @Override
    public void createAccount(CreateAccountRequest createAccountRequest) {
        Account account = new Account(createAccountRequest.getName(), createAccountRequest.getAge(), createAccountRequest.getMobile(), createAccountRequest.getAddress(), createAccountRequest.getUsername(), createAccountRequest.getPassword(), false);
        accountRepository.save(account);

    }

    @Modifying
    @Override
    public void updateAccount(int id, UpdateAccountRequest updateAccountRequest) {
        Account account = new Account(id, updateAccountRequest.getName(), updateAccountRequest.getAge(), updateAccountRequest.getMobile(), updateAccountRequest.getAddress(), updateAccountRequest.getUsername(), updateAccountRequest.getPassword(), false);

        accountRepository.save(account);
    }
    @Modifying
    @Override
    public void deleteAccount(int id) {
        accountRepository.removeAccount(true, id);
    }


}
