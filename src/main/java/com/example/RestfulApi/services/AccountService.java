package com.example.RestfulApi.services;

import com.example.RestfulApi.dto.AccountDto;
import com.example.RestfulApi.entities.Account;
import com.example.RestfulApi.request.CreateAccountRequest;
import com.example.RestfulApi.request.UpdateAccountRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<AccountDto> getAccountByIdOrMobile(int id, String mobile);
    void createAccount(CreateAccountRequest createAccountRequest);
    void updateAccount(int id, UpdateAccountRequest updateAccountRequest);
    void deleteAccount(int id);
}
