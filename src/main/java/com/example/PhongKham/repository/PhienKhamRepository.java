package com.example.PhongKham.repository;

import com.example.PhongKham.model.PhienKham;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhienKhamRepository {
    List<PhienKham> findAll();
    PhienKham findId(int id);
    void add(PhienKham phienkham);
    void edit(PhienKham phienkham);
    void delete(int id);
    List<PhienKham> findName(String name);
}
