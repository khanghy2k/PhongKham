package com.example.PhongKham.repository;

import com.example.PhongKham.model.LichHen;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichHenRepository {
    List<LichHen> findAll();
    LichHen findId(int id);
    void add(LichHen lichHen);
    void edit(LichHen lichHen);
    void delete(int id);

}
