package com.example.PhongKham.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
    public static Connection open(){
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection("jdbc:mysql://localhost:3306/phong_kham", "root", "khanghy123");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        return null;
    }
}
