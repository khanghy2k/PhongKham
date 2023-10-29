package com.example.PhongKham.service;

import com.example.PhongKham.model.LichHen;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LichHenService {
    List<LichHen> findAll();
    LichHen findId(int id);
    void add(LichHen lichHen);
    void edit(LichHen lichHen);
    void delete(int id);
}
