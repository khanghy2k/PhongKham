package com.example.PhongKham.service;

import com.example.PhongKham.model.DichVu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DichVuService {
    List<DichVu> findAll();
    void add(DichVu dichVu);
    void edit(DichVu dichVu);
    void delete(int MaDichVu);
    DichVu findId(int MaDichVu);
}
