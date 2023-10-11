package com.example.PhongKham.service;

import com.example.PhongKham.model.BenhNhan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BenhnhanService {
    List<BenhNhan> findAll();
    BenhNhan findId(int id);
    void add(BenhNhan benhNhan);
    void edit(BenhNhan benhNhan);
    void delete(int id);
}
