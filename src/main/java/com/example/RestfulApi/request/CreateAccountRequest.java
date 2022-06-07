package com.example.RestfulApi.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountRequest {

    private String name;
    private int age;
    private String mobile;
    private String address;
    private String username;
    private String password;
}
