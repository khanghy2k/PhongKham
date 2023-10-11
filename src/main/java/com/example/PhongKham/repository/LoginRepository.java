package com.example.PhongKham.repository;

import com.example.PhongKham.model.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository {
    Users findbyLogin(String username,String password);
    void register(Users users);
    boolean isUsernameExists(String username,String email);
    Users findByUsername(String username);

}
