package com.example.PhongKham.service.impl;

import com.example.PhongKham.model.DichVu;
import com.example.PhongKham.repository.DichVuRepository;
import com.example.PhongKham.service.DichVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DichVuServiceImpl implements DichVuService {

    @Autowired
    private DichVuRepository dichVuRepository;

    @Override
    public List<DichVu> findAll() {
        return dichVuRepository.findAll();
    }

    @Override
    public void add(DichVu dichVu) {
        dichVuRepository.add(dichVu);
    }

    @Override
    public void edit(DichVu dichVu) {
        dichVuRepository.edit(dichVu);
    }

    @Override
    public void delete(int MaDichVu) {
        dichVuRepository.delete(MaDichVu);
    }

    @Override
    public DichVu findId(int MaDichVu) {
        return dichVuRepository.findId(MaDichVu);
    }
}
