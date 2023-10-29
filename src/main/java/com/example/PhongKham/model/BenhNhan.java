package com.example.PhongKham.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class BenhNhan {
    private Integer MaBenhnhan;
    @NotEmpty(message = "Tên Bệnh Nhân không được để trống")
    @NotBlank(message = "Tên Bệnh Nhân không được chứa khoảng trắng")
    private String TenBenhnhan;
    @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Ngaysinh;
    @NotEmpty(message = "Giới Tính không được để trống")
    @NotBlank(message = "Giới Tính không được chứa khoảng trắng")
    private String Gioitinh;
    @NotEmpty(message = "Địa Chỉ không được để trống")
    @NotBlank(message = "Địa Chỉ không được chứa khoảng trắng")
    private String Diachi;
    @NotEmpty(message = "Số Điện Thoại không được để trống")
    private String Sodienthoai;
    @NotEmpty(message = "Email không hợp lệ")
    private String Email;
    private Integer CanNang;
    private Integer ChieuCao;
    private String Nhommau;
    private String DiUng;

    public BenhNhan() {
    }

    public BenhNhan(Integer maBenhnhan, String tenBenhnhan, Date ngaysinh, String gioitinh, String diachi, String sodienthoai, String email, Integer canNang, Integer chieuCao, String nhommau, String diUng) {
        MaBenhnhan = maBenhnhan;
        TenBenhnhan = tenBenhnhan;
        Ngaysinh = ngaysinh;
        Gioitinh = gioitinh;
        Diachi = diachi;
        Sodienthoai = sodienthoai;
        Email = email;
        CanNang = canNang;
        ChieuCao = chieuCao;
        Nhommau = nhommau;
        DiUng = diUng;
    }

    public Integer getMaBenhnhan() {
        return MaBenhnhan;
    }

    public void setMaBenhnhan(Integer maBenhnhan) {
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

    public Integer getCanNang() {
        return CanNang;
    }

    public void setCanNang(Integer canNang) {
        CanNang = canNang;
    }

    public Integer getChieuCao() {
        return ChieuCao;
    }

    public void setChieuCao(Integer chieuCao) {
        ChieuCao = chieuCao;
    }

    public String getNhommau() {
        return Nhommau;
    }

    public void setNhommau(String nhommau) {
        Nhommau = nhommau;
    }

    public String getDiUng() {
        return DiUng;
    }

    public void setDiUng(String diUng) {
        DiUng = diUng;
    }
}
