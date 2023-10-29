package com.example.PhongKham.repository;

import com.example.PhongKham.model.Thuoc;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DonthuocRepository {
    List<Thuoc> findAll();
    Thuoc findId(int id);
    void add(Thuoc thuoc);
    void edit(Thuoc thuoc);
    void delete(int id);
}
