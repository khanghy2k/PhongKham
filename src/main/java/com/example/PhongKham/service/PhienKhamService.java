package com.example.PhongKham.service;

import com.example.PhongKham.model.PhienKham;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhienKhamService {
    List<PhienKham> findAll();
    PhienKham findId(int id);
    void add(PhienKham phienkham);
    void edit(PhienKham phienkham);
    void delete(int id);
    List<PhienKham> findName(String name);

}
