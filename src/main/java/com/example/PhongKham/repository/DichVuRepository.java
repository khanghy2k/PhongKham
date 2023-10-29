package com.example.PhongKham.repository;

import com.example.PhongKham.model.DichVu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DichVuRepository {
    List<DichVu> findAll();
    void add(DichVu dichVu);
    void edit(DichVu dichVu);
    void delete(int MaDichVu);
    DichVu findId(int MaDichVu);
}
