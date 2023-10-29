package com.example.PhongKham.repository.impl;

import com.example.PhongKham.model.PhienKham;
import com.example.PhongKham.repository.PhienKhamRepository;
import com.example.PhongKham.util.MySqlConnection;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class PhienKhamRepositoryImpl implements PhienKhamRepository {
    @Override
    public List<PhienKham> findAll() {
        List<PhienKham> phienKhamList = new ArrayList<>();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("call sp_phienkham_select()");
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()){
                    PhienKham p = new PhienKham();
                    p.setMaPhienKham(resultSet.getInt("MaPhienKham"));
                    p.setMaBenhNhan(resultSet.getInt("MaBenhNhan"));
                    p.setNgayKham(new Date(resultSet.getTimestamp("NgayKham").getTime()));
                    p.setTrieuChung(resultSet.getString("TrieuChung"));
                    p.setKetLuan(resultSet.getString("KetLuan"));
                    p.setTienKham(resultSet.getInt("TienKham"));
                    p.setTienThuoc(resultSet.getInt("TienThuoc"));
                    p.setTrangThai(resultSet.getString("trangThai"));
                    p.setTongTien(resultSet.getInt("TongTien"));
                    p.setMaDichVu(resultSet.getInt("Ma_Dich_vu"));
                    p.setMaThuoc(resultSet.getInt("Ma_Don_Thuoc"));
                    phienKhamList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
      return phienKhamList;
    }

    @Override
    public PhienKham findId(int id) {
        return null;
    }

    @Override
    public void add(PhienKham phienkham) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("call sp_phienkham_insert(?,?,?,?,?,?,?)");
            cs.setInt(1,phienkham.getMaBenhNhan());
            cs.setTimestamp(2,new Timestamp(phienkham.getNgayKham().getTime()));
            cs.setString(3,phienkham.getTrieuChung());
            cs.setString(4,phienkham.getKetLuan());
            cs.setInt(5,phienkham.getTienKham());
            cs.setInt(6,phienkham.getTienThuoc());
            cs.setString(7,phienkham.getTrangThai());
            int result = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void edit(PhienKham phienkham) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<PhienKham> findName(String name) {
        return null;
    }
}
