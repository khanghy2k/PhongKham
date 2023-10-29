package com.example.PhongKham.service;

import com.example.PhongKham.model.Thuoc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DonThuocService {
    List<Thuoc> findAll();
    Thuoc findId(int id);
    void add(Thuoc thuoc);
    void edit(Thuoc thuoc);
    void delete(int id);
}
