package com.example.PhongKham.service.impl;

import com.example.PhongKham.model.Users;
import com.example.PhongKham.repository.LoginRepository;
import com.example.PhongKham.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class LoginServiceImpl implements LoginService {



    @Autowired
    private LoginRepository loginRepository;




    @Override
    public Users findbyLogin(String username, String password) {
        return loginRepository.findbyLogin(username,password);
    }

    @Override
    public void register(Users users) {
        loginRepository.register(users);
    }

    @Override
    public boolean isUsernameExists(String username, String email) {
        return loginRepository.isUsernameExists(username, email);
    }

    @Override
    public Users findByUsername(String username) {
        return loginRepository.findByUsername(username);
    }


}








