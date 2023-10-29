package com.example.PhongKham.service.impl;

import com.example.PhongKham.model.LichHen;
import com.example.PhongKham.repository.LichHenRepository;
import com.example.PhongKham.service.LichHenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LichHenServiceImpl implements LichHenService {

    @Autowired
    private LichHenRepository lichHenRepository;

    @Override
    public List<LichHen> findAll() {
        return lichHenRepository.findAll();
    }

    @Override
    public LichHen findId(int id) {

        return lichHenRepository.findId(id);
    }

    @Override
    public void add(LichHen lichHen) {
        lichHenRepository.add(lichHen);
    }

    @Override
    public void edit(LichHen lichHen) {
        lichHenRepository.edit(lichHen);
    }

    @Override
    public void delete(int id) {
         lichHenRepository.delete(id);
    }
}
