package com.example.PhongKham.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class LichHen {
    private int MaLichHen;
    private int MaBenhNhan;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date ThoiGian;
    private String Noidung;

    public LichHen() {
    }

    public LichHen(int maLichHen, int maBenhNhan, Date thoiGian, String noidung) {
        MaLichHen = maLichHen;
        MaBenhNhan = maBenhNhan;
        ThoiGian = thoiGian;
        Noidung = noidung;
    }

    public int getMaLichHen() {
        return MaLichHen;
    }

    public void setMaLichHen(int maLichHen) {
        MaLichHen = maLichHen;
    }

    public int getMaBenhNhan() {
        return MaBenhNhan;
    }

    public void setMaBenhNhan(int maBenhNhan) {
        MaBenhNhan = maBenhNhan;
    }

    public Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Date thoiGian) {
        ThoiGian = thoiGian;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String noidung) {
        Noidung = noidung;
    }
}
