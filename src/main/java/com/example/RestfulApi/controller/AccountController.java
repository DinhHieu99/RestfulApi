package com.example.RestfulApi.controller;

import com.example.RestfulApi.dto.AccountDto;
import com.example.RestfulApi.dto.ResponseDto;
import com.example.RestfulApi.request.CreateAccountRequest;
import com.example.RestfulApi.request.SearchAccountRequest;
import com.example.RestfulApi.request.UpdateAccountRequest;
import com.example.RestfulApi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/accounts")
    public ResponseDto getData(@RequestBody SearchAccountRequest accountRequest) {
        List<AccountDto> accountDtos = accountService.getAccountByIdOrMobile(accountRequest.getId(),
                accountRequest.getMobile());
        return new ResponseDto(200, "Success", accountDtos);
    }
    @GetMapping("/accounts/{id}")
    public ResponseDto getAccountById(@PathVariable int id, @RequestBody SearchAccountRequest accountRequest) {
        List<AccountDto> accountDtos = accountService.getAccountByIdOrMobile(accountRequest.getId(),
                accountRequest.getMobile());
        return new ResponseDto(200, "Success", accountDtos);
    }

    @PostMapping("/accounts")
    public ResponseDto createAccount(@RequestBody CreateAccountRequest accountRequest) {
        accountService.createAccount(accountRequest);
        AccountDto accountDtos = new AccountDto();
        accountDtos.setName(accountRequest.getName());
        accountDtos.setAge(accountRequest.getAge());
        accountDtos.setMobile(accountRequest.getMobile());
        accountDtos.setAddress(accountRequest.getAddress());
        return new ResponseDto(200, "Success", accountDtos);
    }

    @PutMapping("/accounts/{id}")
    public ResponseDto updateAccount(@PathVariable int id, @RequestBody UpdateAccountRequest updateAccountRequest) {
        accountService.updateAccount(id, updateAccountRequest);

        AccountDto accountDtos = new AccountDto();
        accountDtos.setId(id);
        accountDtos.setName(updateAccountRequest.getName());
        accountDtos.setAge(updateAccountRequest.getAge());
        accountDtos.setMobile(updateAccountRequest.getMobile());
        accountDtos.setAddress(updateAccountRequest.getAddress());

        return new ResponseDto(200, "Success", accountDtos);
    }

    @DeleteMapping("/accounts/{id}")
    public ResponseDto removeAccount(@PathVariable int id) {
        accountService.deleteAccount(id);

        return new ResponseDto(200, "Success", null);
    }
}
