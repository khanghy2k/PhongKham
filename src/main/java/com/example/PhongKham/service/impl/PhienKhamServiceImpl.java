package com.example.PhongKham.service.impl;

import com.example.PhongKham.model.PhienKham;
import com.example.PhongKham.repository.PhienKhamRepository;
import com.example.PhongKham.service.PhienKhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhienKhamServiceImpl implements PhienKhamService {

    @Autowired
    private PhienKhamRepository phienKhamRepository;

    @Override
    public List<PhienKham> findAll() {
        return phienKhamRepository.findAll();
    }

    @Override
    public PhienKham findId(int id) {
        return phienKhamRepository.findId(id);
    }

    @Override
    public void add(PhienKham phienkham) {
        phienKhamRepository.add(phienkham);
    }

    @Override
    public void edit(PhienKham phienkham) {
        phienKhamRepository.edit(phienkham);
    }

    @Override
    public void delete(int id) {
        phienKhamRepository.delete(id);
    }

    @Override
    public List<PhienKham> findName(String name) {
        return phienKhamRepository.findName(name);
    }
}
