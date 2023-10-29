package com.example.PhongKham.repository.impl;

import com.example.PhongKham.model.Thuoc;
import com.example.PhongKham.repository.DonthuocRepository;
import com.example.PhongKham.util.MySqlConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DonThuocRepositoryImpl implements DonthuocRepository {
    @Override
    public List<Thuoc> findAll() {
        List<Thuoc> thuocList = new ArrayList<>();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_donthuoc_select()");
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                Thuoc thuoc = new Thuoc();
                thuoc.setMadonthuoc(rs.getInt("madonthuoc"));
                thuoc.setMabenhnhan(rs.getInt("mabenhnhan"));
                thuoc.setTenthuoc(rs.getString("tenthuoc"));
                thuoc.setDonvitinh(rs.getString("donvitinh"));
                thuoc.setSoluong(rs.getInt("soluong"));
                thuoc.setCachdung(rs.getString("cachdung"));
                thuoc.setNgayke(new Date(rs.getTimestamp("ngayke").getTime()));
                thuocList.add(thuoc);
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return thuocList;
    }


    @Override
    public Thuoc findId(int id) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_donthuoc_byId(?) ");
            cs.setInt(1, id);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                Thuoc thuoc = new Thuoc();
                thuoc.setMadonthuoc(rs.getInt("madonthuoc"));
                thuoc.setMabenhnhan(rs.getInt("mabenhnhan"));
                thuoc.setTenthuoc(rs.getString("tenthuoc"));
                thuoc.setDonvitinh(rs.getString("donvitinh"));
                thuoc.setSoluong(rs.getInt("soluong"));
                thuoc.setCachdung(rs.getString("cachdung"));
                thuoc.setNgayke(new Date(rs.getTimestamp("ngayke").getTime()));
                return thuoc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void add(Thuoc thuoc) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn= MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_donthuoc_insert(?,?,?,?,?,?)");
            cs.setInt(1,thuoc.getMabenhnhan());
            cs.setString(2,thuoc.getTenthuoc());
            cs.setString(3,thuoc.getDonvitinh());
            cs.setInt(4,thuoc.getSoluong());
            cs.setString(5,thuoc.getCachdung());
            cs.setTimestamp(6,new Timestamp(thuoc.getNgayke().getTime()));
            int result = cs.executeUpdate();
            if (result == 0) {
                System.out.println("Thêm thất bại");
            } else {
                System.out.println("Thêm thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void edit(Thuoc thuoc) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_donthuoc_update(?,?,?,?,?,?,?)");
            cs.setInt(1,thuoc.getMadonthuoc());
            cs.setInt(2,thuoc.getMabenhnhan());
            cs.setString(3,thuoc.getTenthuoc());
            cs.setString(4,thuoc.getDonvitinh());
            cs.setInt(5,thuoc.getSoluong());
            cs.setString(6,thuoc.getCachdung());
            cs.setTimestamp(7,new Timestamp(thuoc.getNgayke().getTime()));
            int result = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_donthuoc_delete(?)");
            cs.setInt(1,id);
            int result = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                cs.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
