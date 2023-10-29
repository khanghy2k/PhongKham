package com.example.PhongKham.repository.impl;

import com.example.PhongKham.model.BenhNhan;
import com.example.PhongKham.repository.BenhnhanRepository;
import com.example.PhongKham.util.MySqlConnection;
import org.springframework.beans.factory.annotation.Autowired;
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
                b.setCanNang(resultSet.getInt("Can_nang"));
                b.setChieuCao(resultSet.getInt("Chieu_cao"));
                b.setNhommau(resultSet.getString("Nhom_mau"));
                b.setDiUng(resultSet.getString("Di_ung"));
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
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_benh_nhan_byId(?)");
            cs.setInt(1, id);
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
                b.setCanNang(resultSet.getInt("Can_nang"));
                b.setChieuCao(resultSet.getInt("Chieu_cao"));
                b.setNhommau(resultSet.getString("Nhom_mau"));
                b.setDiUng(resultSet.getString("Di_ung"));
                return b;
            }
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
        return null;
    }


    @Override
    public void add(BenhNhan benhNhan) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_benh_nhan_insert(?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, benhNhan.getTenBenhnhan());
            cs.setTimestamp(2, new Timestamp(benhNhan.getNgaysinh().getTime()));
            cs.setString(3, benhNhan.getGioitinh());
            cs.setString(4, benhNhan.getDiachi());
            cs.setString(5, benhNhan.getSodienthoai());
            cs.setString(6, benhNhan.getEmail());
            cs.setInt(7, benhNhan.getCanNang());
            cs.setInt(8, benhNhan.getChieuCao());
            cs.setString(9, benhNhan.getNhommau());
            cs.setString(10, benhNhan.getDiUng());
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
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_benh_nhan_update(?,?,?,?,?,?,?,?,?,?,?)");
            cs.setInt(1, benhNhan.getMaBenhnhan());
            cs.setString(2, benhNhan.getTenBenhnhan());
            cs.setTimestamp(3, new Timestamp(benhNhan.getNgaysinh().getTime()));
            cs.setString(4, benhNhan.getGioitinh());
            cs.setString(5, benhNhan.getDiachi());
            cs.setString(6, benhNhan.getSodienthoai());
            cs.setString(7, benhNhan.getEmail());
            cs.setInt(8, benhNhan.getCanNang());
            cs.setInt(9, benhNhan.getChieuCao());
            cs.setString(10, benhNhan.getNhommau());
            cs.setString(11, benhNhan.getDiUng());
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
    public void delete(int id) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_benh_nhan_delete(?)");
            cs.setInt(1, id);
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
    public List<BenhNhan> findName(String name) {
        Connection cn = null;
        CallableStatement cs = null;
        List<BenhNhan> benhNhans = new ArrayList<>();
        if (name == null || name.isEmpty()) {
            return findAll();
        }
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_benh_nhan_search(?)");
            cs.setString(1, "%" + name + "%");
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
                b.setCanNang(resultSet.getInt("Can_nang"));
                b.setChieuCao(resultSet.getInt("Chieu_cao"));
                b.setNhommau(resultSet.getString("Nhom_mau"));
                b.setDiUng(resultSet.getString("Di_ung"));
                benhNhans.add(b);
            }
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
        return benhNhans;
    }

    @Override
    public List<BenhNhan> findLichHen(int id) {
        List<BenhNhan> benhNhans = new ArrayList<>();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("call sp_lichhen_byId(?)");
            cs.setInt(1, id);
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
                b.setCanNang(resultSet.getInt("Can_nang"));
                b.setChieuCao(resultSet.getInt("Chieu_cao"));
                b.setNhommau(resultSet.getString("Nhom_mau"));
                b.setDiUng(resultSet.getString("Di_ung"));
                benhNhans.add(b);
            }
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
        return benhNhans;
    }

    @Override
    public List<BenhNhan> pageBenhNhan(int limit, int offset) {
        List<BenhNhan> benhNhans = new ArrayList<>();
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_benhnhan_pagination(?,?)");
            cs.setInt(1, limit);
            cs.setInt(2, offset);
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
                b.setCanNang(resultSet.getInt("Can_nang"));
                b.setChieuCao(resultSet.getInt("Chieu_cao"));
                b.setNhommau(resultSet.getString("Nhom_mau"));
                b.setDiUng(resultSet.getString("Di_ung"));
                benhNhans.add(b);
            }
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
        return benhNhans;
    }


}
