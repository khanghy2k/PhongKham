package com.example.PhongKham.service.impl;

import com.example.PhongKham.model.BenhNhan;
import com.example.PhongKham.repository.BenhnhanRepository;
import com.example.PhongKham.service.BenhnhanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BenhNhanServiceImpl implements BenhnhanService {
    @Autowired
    private BenhnhanRepository benhnhanRepository;


    @Override
    public List<BenhNhan> findAll() {
        return benhnhanRepository.findAll();
    }

    @Override
    public BenhNhan findId(int id) {
        return benhnhanRepository.findId(id);
    }

    @Override
    public void add(BenhNhan benhNhan) {
        benhnhanRepository.add(benhNhan);
    }

    @Override
    public void edit(BenhNhan benhNhan) {
        benhnhanRepository.edit(benhNhan);
    }

    @Override
    public void delete(int id) {
        benhnhanRepository.delete(id);
    }

}
