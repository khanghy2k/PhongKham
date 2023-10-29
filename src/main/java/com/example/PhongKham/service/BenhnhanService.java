package com.example.PhongKham.service;

import com.example.PhongKham.model.BenhNhan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BenhnhanService {
    List<BenhNhan> findAll();
    BenhNhan findId(int id);
    List<BenhNhan> findName(String name);
    void add(BenhNhan benhNhan);
    void edit(BenhNhan benhNhan);
    void delete(int id);
    List<BenhNhan> findLichHen(int id);
    List<BenhNhan> pageBenhNhan(int limit, int offset);
}
