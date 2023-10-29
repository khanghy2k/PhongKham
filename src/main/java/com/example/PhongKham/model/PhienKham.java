package com.example.PhongKham.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class PhienKham {
    private Integer MaPhienKham;
    private Integer MaBenhNhan;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date NgayKham;
    @NotEmpty(message = "Triệu Chứng không được để trống")
    private String TrieuChung;
    @NotEmpty(message = "Kết Luận không được để trống")
    private String KetLuan;
    private Integer TienKham;
    private Integer TienThuoc;
    private Integer TongTien;
    private String TrangThai;
    private Integer MaDichVu;
    private Integer MaThuoc;

    public PhienKham() {
    }

    public PhienKham(Integer maPhienKham, Integer maBenhNhan, Date ngayKham, String trieuChung, String ketLuan, Integer tienKham, Integer tienThuoc, Integer tongTien, String trangThai, Integer maDichVu, Integer maThuoc) {
        MaPhienKham = maPhienKham;
        MaBenhNhan = maBenhNhan;
        NgayKham = ngayKham;
        TrieuChung = trieuChung;
        KetLuan = ketLuan;
        TienKham = tienKham;
        TienThuoc = tienThuoc;
        TongTien = tongTien;
        TrangThai = trangThai;
        MaDichVu = maDichVu;
        MaThuoc = maThuoc;
    }

    public Integer getMaPhienKham() {
        return MaPhienKham;
    }

    public void setMaPhienKham(Integer maPhienKham) {
        MaPhienKham = maPhienKham;
    }

    public Integer getMaBenhNhan() {
        return MaBenhNhan;
    }

    public void setMaBenhNhan(Integer maBenhNhan) {
        MaBenhNhan = maBenhNhan;
    }

    public Date getNgayKham() {
        return NgayKham;
    }

    public void setNgayKham(Date ngayKham) {
        NgayKham = ngayKham;
    }

    public String getTrieuChung() {
        return TrieuChung;
    }

    public void setTrieuChung(String trieuChung) {
        TrieuChung = trieuChung;
    }

    public String getKetLuan() {
        return KetLuan;
    }

    public void setKetLuan(String ketLuan) {
        KetLuan = ketLuan;
    }

    public Integer getTienKham() {
        return TienKham;
    }

    public void setTienKham(Integer tienKham) {
        TienKham = tienKham;
    }

    public Integer getTienThuoc() {
        return TienThuoc;
    }

    public void setTienThuoc(Integer tienThuoc) {
        TienThuoc = tienThuoc;
    }

    public Integer getTongTien() {
        return TongTien;
    }

    public void setTongTien(Integer tongTien) {
        TongTien = tongTien;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public Integer getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(Integer maDichVu) {
        MaDichVu = maDichVu;
    }

    public Integer getMaThuoc() {
        return MaThuoc;
    }

    public void setMaThuoc(Integer maThuoc) {
        MaThuoc = maThuoc;
    }
}

