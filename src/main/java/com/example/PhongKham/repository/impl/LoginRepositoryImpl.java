package com.example.PhongKham.repository.impl;

import com.example.PhongKham.model.Users;
import com.example.PhongKham.repository.LoginRepository;
import com.example.PhongKham.util.MySqlConnection;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Date;


@Repository
public class LoginRepositoryImpl implements LoginRepository {
    @Override
    public Users findbyLogin(String username, String password) {
        Connection conn = null;
        CallableStatement cs = null;
        try {
            conn = MySqlConnection.open();
            cs = conn.prepareCall("CALL sp_users_select_login(?,?)");
            cs.setString(1, username);
            cs.setString(2, password);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Users u = new Users();
                u.setId(rs.getString("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setCreated_at(new Date(rs.getTimestamp("created_at").getTime()));
                return u;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void register(Users users) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_users_insert(?,?,?)");
            cs.setString(1, users.getUsername());
            cs.setString(2, users.getPassword());
            cs.setString(3, users.getEmail());
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
    public boolean isUsernameExists(String username, String email) {
        Connection cn = null;
        CallableStatement cs = null;
        try {
            cn = MySqlConnection.open();
            cs = cn.prepareCall("CALL sp_users_select_byName(?,?)");
            cs.setString(1, username);
            cs.setString(2, email);
            ResultSet rs = cs.executeQuery();
            return rs.next();
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
        return false;
    }

    @Override
    public Users findByUsername(String username) {
        Connection cn = null;
        PreparedStatement cs = null;
        if (username == null || username.isEmpty()) {
            return null;
        }
        try {
            cn = MySqlConnection.open();
            assert cn != null;
            cs = cn.prepareCall("CALL sp_users_findby_Name(?)");
            cs.setString(1, username);
            ResultSet rs = cs.executeQuery();
            while (rs.next()) {
                Users u = new Users();
                u.setId(rs.getString("id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                u.setCreated_at(new Date(rs.getTimestamp("created_at").getTime()));
                return u;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // Đóng kết nối
            try {
                assert cs != null;
                cs.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}







