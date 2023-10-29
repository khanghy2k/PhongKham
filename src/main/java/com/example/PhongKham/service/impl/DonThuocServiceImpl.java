package com.example.PhongKham.service.impl;

import com.example.PhongKham.model.Thuoc;
import com.example.PhongKham.repository.DonthuocRepository;
import com.example.PhongKham.service.DonThuocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonThuocServiceImpl implements DonThuocService {

    @Autowired
    private DonthuocRepository donthuocRepository;

    @Override
    public List<Thuoc> findAll() {
        return donthuocRepository.findAll();
    }

    @Override
    public Thuoc findId(int id) {
        return donthuocRepository.findId(id);
    }

    @Override
    public void add(Thuoc thuoc) {
        donthuocRepository.add(thuoc);
    }

    @Override
    public void edit(Thuoc thuoc) {
        donthuocRepository.edit(thuoc);
    }

    @Override
    public void delete(int id) {
        donthuocRepository.delete(id);
    }
}
