package com.example.PhongKham.service;

import com.example.PhongKham.model.Users;
import org.springframework.stereotype.Service;


@Service
public interface LoginService {
    Users findbyLogin(String username,String password);
    void register(Users users);
    boolean isUsernameExists(String username,String email);
    Users findByUsername(String username);
}
