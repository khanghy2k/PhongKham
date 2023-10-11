package com.example.PhongKham.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



public class BenhNhan {
    private int MaBenhnhan;
    private String TenBenhnhan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Ngaysinh;
    private String Gioitinh;
    private String Diachi;
    private String Sodienthoai;
    private String Email;

    public BenhNhan() {
    }

    public BenhNhan(int maBenhnhan, String tenBenhnhan, Date ngaysinh, String gioitinh, String diachi, String sodienthoai, String email) {
        MaBenhnhan = maBenhnhan;
        TenBenhnhan = tenBenhnhan;
        Ngaysinh = ngaysinh;
        Gioitinh = gioitinh;
        Diachi = diachi;
        Sodienthoai = sodienthoai;
        Email = email;
    }

    public int getMaBenhnhan() {
        return MaBenhnhan;
    }

    public void setMaBenhnhan(int maBenhnhan) {
        MaBenhnhan = maBenhnhan;
    }

    public String getTenBenhnhan() {
        return TenBenhnhan;
    }

    public void setTenBenhnhan(String tenBenhnhan) {
        TenBenhnhan = tenBenhnhan;
    }

    public Date getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        Ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        Gioitinh = gioitinh;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getSodienthoai() {
        return Sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        Sodienthoai = sodienthoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
