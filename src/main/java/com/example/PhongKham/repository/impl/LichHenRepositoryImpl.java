package com.example.PhongKham.repository.impl;
import com.example.PhongKham.model.LichHen;
import com.example.PhongKham.repository.LichHenRepository;
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
public class LichHenRepositoryImpl implements LichHenRepository {
    @Override
    public List<LichHen> findAll() {
        List<LichHen> lichHens = new ArrayList<>();
        Connection cn =  null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_LichHen_select()");
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()){
                LichHen lichHen = new LichHen();
                lichHen.setMaLichHen(resultSet.getInt("MaLichhen"));
                lichHen.setMaBenhNhan(resultSet.getInt("MaBenhnhan"));
                lichHen.setThoiGian(new Date(resultSet.getTimestamp("Thoigian").getTime()));
                lichHen.setNoidung(resultSet.getString("Noidung"));
                lichHens.add(lichHen);
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
        return lichHens;
    }

    @Override
    public LichHen findId(int id) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_lichhen_UpdateID(?)");
            cs.setInt(1, id);
            ResultSet resultSet = cs.executeQuery();
            while (resultSet.next()){
                LichHen lichHen = new LichHen();
                lichHen.setMaLichHen(resultSet.getInt("MaLichhen"));
                lichHen.setMaBenhNhan(resultSet.getInt("MaBenhnhan"));
                lichHen.setThoiGian(new Date(resultSet.getTimestamp("Thoigian").getTime()));
                lichHen.setNoidung(resultSet.getString("Noidung"));
                return lichHen;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                cs.close();
                cn.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void add(LichHen lichHen) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_LichHen_insert(?,?,?)");
            cs.setInt(1, lichHen.getMaBenhNhan());
            cs.setTimestamp(2, new Timestamp(lichHen.getThoiGian().getTime()));
            cs.setString(3, lichHen.getNoidung());
            int result = cs.executeUpdate();
            if (result == 0) {
                throw new Exception("Thêm mới không thành công");
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
    }

    @Override
    public void edit(LichHen lichHen) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_lichhen_update(?,?,?,?)");
            cs.setInt(1,lichHen.getMaLichHen());
            cs.setInt(2, lichHen.getMaBenhNhan());
            cs.setTimestamp(3, new Timestamp(lichHen.getThoiGian().getTime()));
            cs.setString(4, lichHen.getNoidung());
            int result = cs.executeUpdate();
            if (result == 0) {
                throw new Exception("Cập nhật không thành công");
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
    }

    @Override
    public void delete(int id) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            assert cn != null;
            cs = cn.prepareCall("CALL sp_lichhen_delete(?)");
            cs.setInt(1, id);
            int result = cs.executeUpdate();
            if (result == 0) {
                throw new Exception("Xóa không thành công");
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
    }

}
