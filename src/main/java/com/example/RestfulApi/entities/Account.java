package com.example.RestfulApi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment.
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", columnDefinition = "text", nullable = false)
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "address")
    private String address;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Account(String name, int age, String mobile, String address, String username, String password, boolean isDeleted) {
        this.name = name;
        this.age = age;
        this.mobile = mobile;
        this.address = address;
        this.username = username;
        this.password = password;
        this.isDeleted = isDeleted;
    }
}

