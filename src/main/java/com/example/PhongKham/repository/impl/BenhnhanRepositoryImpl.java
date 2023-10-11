package com.example.PhongKham.repository.impl;

import com.example.PhongKham.model.BenhNhan;
import com.example.PhongKham.repository.BenhnhanRepository;
import com.example.PhongKham.util.MySqlConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class BenhnhanRepositoryImpl implements BenhnhanRepository {
    @Override
    public List<BenhNhan> findAll() {
        List<BenhNhan> benhNhans = new ArrayList<>();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            assert cn != null;
            cs = cn.prepareCall("CALL sp_benh_nhan_select()");
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()) {
                BenhNhan b = new BenhNhan();
                b.setMaBenhnhan(resultSet.getInt("Ma_Benh_nhan"));
                b.setTenBenhnhan(resultSet.getString("Ten_Benh_nhan"));
                b.setNgaysinh(new Date(resultSet.getTimestamp("Ngay_sinh").getTime()));
                b.setGioitinh(resultSet.getString("Gioi_tinh"));
                b.setDiachi(resultSet.getString("Dia_chi"));
                b.setSodienthoai(resultSet.getString("So_dien_thoai"));
                b.setEmail(resultSet.getString("Email"));
                benhNhans.add(b);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                assert cs != null;
                cs.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return benhNhans;
    }

    @Override
    public BenhNhan findId(int id) {
        return null;
    }

    @Override
    public void add(BenhNhan benhNhan) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_benh_nhan_insert(?,?,?,?,?,?)");
            cs.setString(1,benhNhan.getTenBenhnhan());
            cs.setTimestamp(2,new Timestamp(benhNhan.getNgaysinh().getTime()));
            cs.setString(3,benhNhan.getGioitinh());
            cs.setString(4,benhNhan.getDiachi());
            cs.setString(5,benhNhan.getSodienthoai());
            cs.setString(6,benhNhan.getEmail());
            int result = cs.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
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
    public void edit(BenhNhan benhNhan) {

    }

    @Override
    public void delete(BenhNhan benhNhan) {

    }

}
