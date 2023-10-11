package com.example.PhongKham.repository;

import com.example.PhongKham.model.BenhNhan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenhnhanRepository {
    List<BenhNhan> findAll();
    BenhNhan findId(int id);
    void add(BenhNhan benhNhan);
    void edit(BenhNhan benhNhan);
    void delete(BenhNhan benhNhan);

}
