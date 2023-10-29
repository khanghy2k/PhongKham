package com.example.PhongKham.repository.impl;

import com.example.PhongKham.model.DichVu;
import com.example.PhongKham.repository.DichVuRepository;
import com.example.PhongKham.util.MySqlConnection;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Repository
public class DichvuRepositoryImpl implements DichVuRepository {
    @Override
    public List<DichVu> findAll() {
        List<DichVu> dichVus = new ArrayList<>();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            assert cn != null;
            cs = cn.prepareCall("CALL sp_dichvu_select()");
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                DichVu dichVu = new DichVu();
                dichVu.setMaDichVu(rs.getInt("Ma_Dich_vu"));
                dichVu.setTenDichVu(rs.getString("Ten_Dich_vu"));
                dichVu.setMota(rs.getString("Mo_ta"));
                dichVu.setGia(rs.getInt("Gia"));
                dichVus.add(dichVu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert cs != null;
                cs.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dichVus;
    }

    @Override
    public void add(DichVu dichVu) {
            Connection cn = null;
            CallableStatement cs = null;
            try {
                cn = MySqlConnection.open();
                cs = cn.prepareCall("CALL sp_dichvu_insert(?,?,?)");
                cs.setString(1, dichVu.getTenDichVu());
                cs.setString(2, dichVu.getMota());
                cs.setInt(3, dichVu.getGia());
                int i = cs.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    assert cs != null;
                    cs.close();
                    cn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
    }

    @Override
    public void edit(DichVu dichVu) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_dichvu_update(?,?,?,?)");
            cs.setInt(1, dichVu.getMaDichVu());
            cs.setString(2, dichVu.getTenDichVu());
            cs.setString(3, dichVu.getMota());
            cs.setInt(4, dichVu.getGia());
            int i = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert cs != null;
                cs.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int MaDichVu) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_dichvu_delete(?)");
            cs.setInt(1, MaDichVu);
            int i = cs.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert cs != null;
                cs.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public DichVu findId(int MaDichVu) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_dichvu_byId(?)");
            cs.setInt(1, MaDichVu);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
                DichVu dichVu = new DichVu();
                dichVu.setMaDichVu(rs.getInt("Ma_Dich_vu"));
                dichVu.setTenDichVu(rs.getString("Ten_Dich_vu"));
                dichVu.setMota(rs.getString("Mo_ta"));
                dichVu.setGia(rs.getInt("Gia"));
                return dichVu;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert cs != null;
                cs.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
